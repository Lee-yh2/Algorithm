package algolithm.BOJ.greedy.백준1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine()+"=";

        int sum = 0;
        int minus = 0;
        int isMinus = 0;
        String saveNum = "";
        for(int i = 0; i < str.length(); i++){
            // 1. 숫자인지 아닌지 구분하여 숫자일시 예비 String에 담기
            if(Character.isDigit(str.charAt(i))){
                saveNum += str.charAt(i);
            }else{
                if(isMinus == 0)
                    sum += Integer.parseInt(saveNum);
                else
                    minus += Integer.parseInt(saveNum);

                saveNum = "";

                // -가 한번이라도 나오면 그 뒤는 무조건 -가 됨
                if(str.charAt(i) == '-')
                    isMinus = -1;
            }
        }
        System.out.println(sum - minus);
    }
}
