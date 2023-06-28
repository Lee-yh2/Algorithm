package algolithm.BOJ.dp.백준11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
//        while (T-- > 0){
//            int k = Integer.parseInt(br.readLine());
//            int[] list = new int[k];
//
//            st = new StringTokenizer(br.readLine());
//
//        }
        while (T-- > 0){
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> list = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++){
                list.add(Long.parseLong(st.nextToken()));
            }

            // 소설 장의 개수 최대 100만 * 파일 크기 최대 10000 = 100억
            long sum = 0;
            while (list.size() > 1){
                long a = list.poll();
                long b = list.poll();

                sum += a+b;
                list.add(a+b);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
