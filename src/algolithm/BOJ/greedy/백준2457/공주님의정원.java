package algolithm.BOJ.greedy.백준2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Flower implements Comparable<Flower>{
    int start;
    int end;

    public Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Flower o) {
        if(start == o.start) {
                return o.end - end;
        }
        return start - o.start;
    }
}
public class 공주님의정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(s, e);
        }

        Arrays.sort(flowers);
        int start = 301;
        int end = 1130;
        int curser = 0;
        int cnt = 0;
        while (start <= end) {

            int maxEnd = 0;
            for (int i = curser; i < n; i++) {
                if(flowers[i].start > start){
                    break;
                }

                if(maxEnd < flowers[i].end) {
                    maxEnd = flowers[i].end;
                    curser = i + 1;
                }

            }
            if(maxEnd == 0)
                break;
            start = maxEnd;
            cnt++;
        }

        System.out.println(start<=end?0:cnt);

    }
}
