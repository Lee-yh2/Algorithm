package algolithm.BOJ.graphtraversal.백준16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A에서B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = 1;
        while (true){
            if(a == b)
                break;
            else if(a > b){
                result = -1;
                break;
            }

            String str = String.valueOf(b);
            if(b % 2 == 0){
                b /= 2;
            }
            else if(str.charAt(str.length()-1) == '1'){
                str = str.substring(0, str.length()-1);
                b = Integer.parseInt(str);
            } else{
                result = -1;
                break;
            }

            result++;
        }
        System.out.print(result);
    }
}
