package algolithm.BOJ.datastructure2.num07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        PriorityQueue<int[]> maxQue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o2[0]-o1[0];
                return o2[1]-o1[1];
            }
        });
        PriorityQueue<int[]> minQue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            hashmap.put(p, l);
            maxQue.add(new int[]{p, l});
            minQue.add(new int[]{p, l});
        }

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "recommend":
                    if(Integer.parseInt(st.nextToken()) == 1){
                        while(true){
                            int maxK = maxQue.peek()[0];
                            int maxV = maxQue.peek()[1];
                            if(hashmap.containsKey(maxK)){
                                if(hashmap.get(maxK) == maxV) {
                                    sb.append(maxK).append("\n");
                                    break;
                                }
                            }
                            maxQue.poll();
                        }
                    }else{
                        while(true){
                            int minK = minQue.peek()[0];
                            int minV = minQue.peek()[1];
                            if(hashmap.containsKey(minK)){
                                if(hashmap.get(minK) == minV) {
                                    sb.append(minK).append("\n");
                                    break;
                                }
                            }
                            minQue.poll();
                        }
                    }
                    break;
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    hashmap.put(p, l);
                    maxQue.add(new int[]{p, l});
                    minQue.add(new int[]{p, l});
                    break;
                case "solved":
                    int num = Integer.parseInt(st.nextToken());
                    hashmap.remove(num);
                    break;
            }
        }
        System.out.print(sb);
    }
}
