package algolithm.BOJ.datastructure2.num00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class 백준1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int maxNum = Integer.parseInt(st.nextToken());
        int quizNum = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> intPoketmon = new HashMap<>();
        HashMap<String,Integer> strPoketmon = new HashMap<>();
        for(int i = 1; i <= maxNum; i++){
            String name = br.readLine();
            intPoketmon.put(i, name);
            strPoketmon.put(name, i);
        }
        for(int i = 0; i < quizNum; i++){
            String pock = br.readLine();
            if(isNum(pock)){
                sb.append(intPoketmon.get(Integer.parseInt(pock))).append("\n");
            }else{
                sb.append(strPoketmon.get(pock)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isNum(String str){
        for(int i = 0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
