package algolithm.HackersRank.VaccinationDrive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Result{
    public static int findMinimumTime(int center_nodes, List<Integer> center_from, List<Integer> center_to, List<Integer> status){
        List<Integer>[] nodes = new ArrayList[center_nodes+1];
        for (int i = 1; i < center_nodes+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < center_from.size(); i++) {
            nodes[center_from.get(i)].add(center_to.get(i));
        }

        int answer = 0;
        for (int i = 0; i < center_nodes; i++) {
            if(status.get(i) == 1){
                answer = Math.max(answer, bfs(nodes, status, i+1));
            }
        }

        return answer;
    }

    public static int bfs(List<Integer>[] nodes, List<Integer> status, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int[] isVisited = new int[nodes.length];
        Arrays.fill(isVisited, -1);
        isVisited[start] = 0;

        int result = 0;
        while (!q.isEmpty()){
            int cur = q.poll();

            if (status.get(cur) == 3){
                result = isVisited[cur];
                break;
            }

            for(int next : nodes[cur]){
                if(isVisited[next] != -1)
                    continue;

                isVisited[next] = isVisited[cur]+1;
                q.add(next);
            }
        }

        return result;
    }
}
public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
