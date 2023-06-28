package algolithm.BOJ.datastructure.card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();
        int command = Integer.parseInt(br.readLine());
        for(int i = 0; i<command; i++){
            que.add(i+1);
        }

        while(que.size() != 1){
            que.remove();
            if(que.size() != 1){
                que.add(que.remove());
            }
        }
        System.out.println(que.peek());
    }
}
