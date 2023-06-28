package algolithm.BOJ.bruteforce.num09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 백준5568 {
    static String[] numStr;
    static HashSet<String> result = new HashSet<>();
    static int n, k;
    static boolean[] kCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        kCheck = new boolean[n];

        numStr = new String[n];
        for(int i = 0; i < n; i++){
            numStr[i] = br.readLine();
        }

        mix(0,"");
        System.out.println(result.size());
    }

    static void mix(int depth, String mixResult){
        if(depth == k){
            result.add(mixResult);
            return;
        }
        for(int i = 0; i<n; i++){
            if(kCheck[i])
                continue;
            kCheck[i] = true;
            mix(depth+1, mixResult+numStr[i]);
            kCheck[i] = false;
        }
    }
}
