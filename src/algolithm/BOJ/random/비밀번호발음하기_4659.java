package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호발음하기_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String str = br.readLine();
            if(str.equals("end"))
                break;

            sb.append("<").append(str).append("> is ");
            if(!checkPassword(str))
                sb.append("not ");
            sb.append("acceptable.").append("\n");
        }
        System.out.println(sb);
    }

    static boolean checkPassword(String str){
        if (!str.contains("a") && !str.contains("e") && !str.contains("i")
                && !str.contains("o") && !str.contains("u"))
            return false;

        for (int i = 1; i < str.length(); i++) {
            if(i > 1){
                if(isM(str.charAt(i))){
                    if(isM(str.charAt(i-1)) && isM(str.charAt(i-2))){
                        return false;
                    }
                }else {
                    if(!isM(str.charAt(i-1)) && !isM(str.charAt(i-2))){
                        return false;
                    }
                }
            }

            if(str.charAt(i) == str.charAt(i-1)){
                if(str.charAt(i) != 'e' && str.charAt(i) != 'o')
                    return false;
            }
        }
        return true;
    }

    static boolean isM(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        else
            return false;
    }
}
