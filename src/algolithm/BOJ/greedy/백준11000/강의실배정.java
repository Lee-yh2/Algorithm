package algolithm.BOJ.greedy.백준11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class ClassRoom implements Comparable<ClassRoom>{
    int start, end;

    public ClassRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ClassRoom o) {
        if(start == o.start)
            return end - o.end;
        return start - o.start;
    }
}
public class 강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ClassRoom[] list = new ClassRoom[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[i] = new ClassRoom(s, e);
        }
        Arrays.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list[0].end);

        for(int i = 1; i < n; i++){
            if(pq.peek() <= list[i].start){
                pq.poll();
            }
            pq.add(list[i].end);
        }
        System.out.println(pq.size());
    }
}
