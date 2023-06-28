package algolithm.BOJ.datastructure.parenthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int iterNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < iterNum; i++){
            int rightBracket = 0;
            int leftBracket = 0;
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                // (보다 )가 더 많아지게 되면 VPS불가능
                if(leftBracket < rightBracket){
                    break;
                }
                if(str.charAt(j) == ')'){
                    rightBracket++;
                }else if(str.charAt(j) == '('){
                    leftBracket++;
                }
            }
            System.out.println(rightBracket==leftBracket?"YES": "NO");
        }
    }
}
