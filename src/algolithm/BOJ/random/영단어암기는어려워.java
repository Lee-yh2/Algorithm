package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영단어암기는어려워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;

            map.put(str, map.getOrDefault(str, 0)+1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)){
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}
