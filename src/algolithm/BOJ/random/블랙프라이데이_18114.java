package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙프라이데이_18114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nList = new int[N];
        for (int i = 0; i < N; i++) {
            nList[i] = Integer.parseInt(st.nextToken());
        }

        // 물건중에 C랑 같은 무게가 있을 경우
        if(Arrays.stream(nList).anyMatch(n -> n == C)){
            System.out.println(1);
            return;
        }
        Arrays.sort(nList);
        int result = 0;

        int s = 0;
        int e = N-1;
        while (s < e){
            int sum = nList[s] + nList[e];
            if(sum == C){
                result = 1;
                break;
            } else if (sum > C) {
                e--;
            } else if (sum < C) {
                // 3개일 경우도 확인
                int plusOne = C - sum;
                if(Arrays.binarySearch(nList, plusOne) >= 0
                        && plusOne != nList[s] && plusOne != nList[e]){
                    result = 1;
                    break;
                }
                s++;
            }
        }
        System.out.println(result);
    }
}
