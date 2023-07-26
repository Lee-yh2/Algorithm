package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 싸이버개강총회_19583 {
    static HashMap<String, Integer> chatting = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        int result = 0;
        while (true){
            String str = br.readLine();
            if(str == null || str.length() == 0)
                break;

            st = new StringTokenizer(str);
            String time = st.nextToken();
            String name = st.nextToken();

            if(time.compareTo(s) <= 0){
                chatting.put(name, 1);
            }
            else if (time.compareTo(e) >= 0 && time.compareTo(q) <= 0){
                chatting.put(name, chatting.getOrDefault(name, -100000)+1);

                if(chatting.getOrDefault(name, 0) == 2)
                    result++;
            }

        }

        System.out.println(result);
    }
}
