package algolithm.BOJ.datastructure2.num03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQue = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(pQue.size() < n){
                    pQue.add(num);
                }else{
                    if(pQue.peek() < num){
                        pQue.poll();
                        pQue.add(num);
                    }
                }
            }
        }
        System.out.println(pQue.peek());
    }
}
