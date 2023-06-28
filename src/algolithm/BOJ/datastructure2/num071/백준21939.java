package algolithm.BOJ.datastructure2.num071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 백준21939 {
    public static class Pair implements Comparable<Pair>{
        int P, L;

        Pair(int p, int l){
            this.P = p;
            this.L = l;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.L == p.L) {
                return this.P - p.P;
            }
            else {
                return this.L - p.L;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        TreeSet<Pair> minMaxSet = new TreeSet<Pair>();
        HashMap<Integer,Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            minMaxSet.add(new Pair(p, l));
            map.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());

        for(int j=0; j<m; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int p, l;
            switch (cmd) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        System.out.println(minMaxSet.last().P);
                    } else {
                        System.out.println(minMaxSet.first().P);
                    }
                    break;
                case "add":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                    minMaxSet.add(new Pair(p, l));
                    map.put(p, l);
                    break;
                case "solved":
                    p = Integer.parseInt(st.nextToken());
                    l = map.get(p);

                    minMaxSet.remove(new Pair(p, l));
                    map.remove(p);
                    break;
            }
        }
    }
}
