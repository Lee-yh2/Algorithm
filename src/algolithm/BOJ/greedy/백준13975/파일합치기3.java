package algolithm.BOJ.greedy.백준13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 규칙이 뭐지
 * 제일큰것과 작은것 ??
 * 아닌데
 * 음 일단 합치는 횟수가 많아질수록 합이 커지는건 맞다.
 * 그럼 일단 무조건 2개씩 합치는걸로
 * 1 21 3 4 5 35 5 4 3 5 98 21 14 17 32 를 직접 그냥 차례대로 2개씩 계속 합치니까 1000이 넘네
 * 정렬을 해야되나?
 * 오름차순 정렬 해서 해봤더니 974..
 * 아 아니네 오름차순으로 해서 priotyQueue 로 계속 2개씩 합쳐주면 되겟다.
 */
public class 파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
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
