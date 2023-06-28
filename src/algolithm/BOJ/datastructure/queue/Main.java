package algolithm.BOJ.datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();

        int iterNum = Integer.parseInt(br.readLine());
        for(int i = 0; i<iterNum; i++){
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        sb.append(queue.remove()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peek()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peekLast()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
