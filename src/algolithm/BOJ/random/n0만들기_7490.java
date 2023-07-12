package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n0만들기_7490 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dfs(n, 1, 1, 0, 1,"1");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int n, int cur, int num, int sum, int cal, String str){
        if(cur == n){
            sum += num*cal;
            if(sum == 0)
                sb.append(str).append("\n");
            return;
        }

        dfs(n, cur+1, num*10+(cur+1), sum, cal,str+" "+String.valueOf(cur+1));
        dfs(n, cur+1, cur+1, sum+(num*cal), 1,str+"+"+String.valueOf(cur+1));
        dfs(n, cur+1, cur+1, sum+(num*cal), -1,str+"-"+String.valueOf(cur+1));
    }
}
