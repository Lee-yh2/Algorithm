package algolithm.BOJ.greedy.백준2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int[] lengthSencer = new int[n-1];
        for(int i = 0; i < n-1; i++){
            lengthSencer[i] = list[i+1] - list[i];
        }

        Arrays.sort(lengthSencer);

        int result = 0;
        // 건너뛸 수 있는 경우는 k가 2라면 2개로 나눌 수 있으니 거리를 1번 건너뛸 수 있다
        // 즉 k-1번  거리를 구해둔 배열은 n - 1 개이기 때문에 n-1-(k-1) = n - k
        for(int i = 0; i < n - k; i++){
            result += lengthSencer[i];
        }

        System.out.println(result);

    }
}
