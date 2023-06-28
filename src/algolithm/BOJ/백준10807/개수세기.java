package algolithm.BOJ.백준10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i =0; i < n; i++){
            if(list[i] == v)
                result++;
        }

        System.out.print(result);
    }
}
