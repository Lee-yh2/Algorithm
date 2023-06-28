package algolithm.BOJ.twopointer.백준17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str = br.readLine();

            int L = 0;
            int R = str.length() - 1;
            int result = 0;
            while(L < R){
                // 양쪽 두 문자가 같을때
                if(str.charAt(L) == str.charAt(R)){
                    L++;
                    R--;
                }else{// 양쪽 두문자가 다를때
                    if(str.length()%2 == 0){ //문자가 짝수개면 일반문자열
                        result = 2;
                        break;
                    }else{ // 문자가 홀수개일때는 확인
                        if(result == 1){ // 이미 한번 확인 해봤다면 일반문자열
                            result = 2;
                            break;
                        }
                        // L의 다음문자와 R문자가 같다면 유사회문 일수도 있다
                        if(L+1 < R && str.charAt(L+1) == str.charAt(R)){
                            L++;
                            result = 1;
                        }else if(L < R-1 && str.charAt(L) == str.charAt(R-1)){
                            R--;
                            result = 1;
                        }else{
                            result = 2;
                            break;
                        }
                    }
                }
            }
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
