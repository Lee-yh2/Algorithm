package algolithm.BOJ.datastructure.num05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!deque.isEmpty()){
                        sb.append(deque.removeFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "pop_back":
                    if(!deque.isEmpty()){
                        sb.append(deque.removeLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty()?1:0).append("\n");
                    break;
                case "front":
                    if(!deque.isEmpty()){
                        sb.append(deque.peekFirst()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!deque.isEmpty()){
                        sb.append(deque.peekLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
