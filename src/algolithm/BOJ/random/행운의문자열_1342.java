package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 행운의문자열_1342 {
    static int[] alphabet = new int[27];
    static int answer;
    static int length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        length = str.length();
        for (int i = 0; i < str.length(); i++)
            alphabet[str.charAt(i)-'a']++;

        dfs(0,' ');
        System.out.println(answer);
    }

    public static void dfs(int depth,char pre){
        if (depth == length){
            answer++;
            return;
        }

        for (int i = 0; i < 27; i++){
            if (alphabet[i]==0)continue;

            if (pre != (char) (i+'a')){
                alphabet[i]--;
                dfs(depth+1, (char)(i+'a'));
                alphabet[i]++;
            }
        }
    }
}
