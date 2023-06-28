package algolithm.BOJ.greedy.백준1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(end == o.end)
            return start - o.start;
        return end - o.end;
    }
}
public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new Meeting(s, e));
        }

        int cnt = 1;
        Meeting meeting = pq.poll();
        while (!pq.isEmpty()){
            if(meeting.end <= pq.peek().start){
                cnt++;
                meeting = pq.poll();
            }else{
                pq.poll();
            }
        }
        System.out.println(cnt);
    }
}
