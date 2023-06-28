package algolithm.BOJ.sorting.백준1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Times implements Comparable<Times> {
    int startTime;
    int endTime;
    Times(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Times o) {
        if(endTime == o.endTime)
            return startTime - o.startTime;
        return endTime - o.endTime;
    }
}
public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Times[] times = new Times[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Times(start, end);
        }
        Arrays.sort(times);
        int end = times[0].endTime;
        int cnt = 1;
        for(int i = 1; i < n; i++){
           if(end <= times[i].startTime){
             end = times[i].endTime;
             cnt++;
           }
        }
        System.out.println(cnt);
    }
}
