package algolithm.BOJ.datastructure.num10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pipe = br.readLine();
        int checkPipe = 0;
        int pipeNum = 0;
        for(int i = 0; i < pipe.length(); i++){
            if(pipe.charAt(i) == '('){
                checkPipe++;
            }else{
                checkPipe--;
                if(pipe.charAt(i-1) == '('){
                    pipeNum += checkPipe;
                }else{
                    pipeNum++;
                }
            }
        }
        System.out.println(pipeNum);
    }
}
