package codepr;

import java.util.*;


class Result {
    public static List<Integer> degreeOfArray(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        List<Integer>[] cities = new ArrayList[cityNodes+1];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new ArrayList<>();
        }

        for (int i = 0; i < cityFrom.size(); i++) {
            cities[cityFrom.get(i)].add(cityTo.get(i));
            cities[cityTo.get(i)].add(cityFrom.get(i));
        }

        int[] citiesCnt = new int[cityNodes+1];
        bfs(citiesCnt, cities, company);

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < cityNodes; i++) {
            if(citiesCnt[i+1] == 0)
                continue;
            answer.add(i+1);
        }

        Collections.sort(answer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(citiesCnt[o1] == citiesCnt[o2]){
                    return o1.compareTo(o2);
                }
                return citiesCnt[o1] - citiesCnt[o2];
            }
        });

        return answer;
    }

    public static void bfs(int[] citiesCnt, List<Integer>[] cities, int company){
        Queue<Integer> q = new LinkedList<>();
        q.add(company);

        boolean[] isVisited = new boolean[citiesCnt.length];
        isVisited[company] = true;

        while (!q.isEmpty()){
            int curNode = q.poll();

            for (int nextNode : cities[curNode]){
                if(isVisited[nextNode])
                    continue;

                citiesCnt[nextNode] = citiesCnt[curNode]+1;
                isVisited[nextNode] = true;
                q.add(nextNode);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
