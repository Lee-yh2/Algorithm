package algolithm.BOJ.greedy.백준1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        ArrayList<Integer> B = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(A);

        int result = 0;

        for(int i = 0; i < n; i++){
            int bMax = Collections.max(B);
            result += A[i] * bMax;
            B.remove(Integer.valueOf(bMax));
        }
        System.out.println(result);
    }
}
