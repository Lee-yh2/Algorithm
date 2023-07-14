package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (s.equals("I")){
                    map.put(num, map.getOrDefault(num, 0)+1);
                }else {
                    if(map.size() == 0) continue;
                    int minMax;
                    if(num == 1)
                        minMax = map.lastKey();
                    else
                        minMax = map.firstKey();

                    if(map.get(minMax) == 1)
                        map.remove(minMax);
                    else{
                        map.put(minMax, map.get(minMax)-1);
                    }
                }
            }

            if(map.isEmpty())
                sb.append("EMPTY").append("\n");
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
