package algolithm.BOJ.datastructure.num09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Balloon{
    public int num;
    public int dirNum;

    Balloon(int num, int dirNum){
        this.num = num;
        this.dirNum=dirNum;
    }
}

public class 백준2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        //LinkedList 썼다가 ArrayDeque로 수정
        //LinkedList는 다음노드가 있는 곳으로 가려고 다른 간접적인 경로를 거쳐감
        //또한 ArrayDeque는 다음 노드에 대함 추가 참조를 유지할필요가 없어
        //큐를 사용할 때는 속도와 메모리 면에서 효율적
        Deque<Balloon> deque = new ArrayDeque<>();

        for(int i = 0; i < num; i++){
            deque.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }

        Balloon bal = deque.removeFirst();
        sb.append(bal.num).append(" ");
        while(!deque.isEmpty()){

            for (int i = 1; i < Math.abs(bal.dirNum); i++) {
                if (bal.dirNum > 0) {
                    deque.addLast(deque.removeFirst());
                } else {
                    deque.addFirst(deque.removeLast());
                }
            }

            if (bal.dirNum > 0) {
                bal = deque.removeFirst();
                sb.append(bal.num).append(" ");
            }else{
                bal = deque.removeLast();
                sb.append(bal.num).append(" ");
            }
        }
        System.out.println(sb);
    }
}