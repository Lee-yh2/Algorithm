package algolithm.BOJ.datastructure.num08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<int[]> que = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine(), " ");
            //크기와, 찾을 문서위치
            int size = Integer.parseInt(st.nextToken());
            int sel = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <size; j++){
                //처음 위치와 중요도
                que.add(new int[]{j,Integer.parseInt(st.nextToken())});
            }
            int printNum = 0;
            while(true){
                int[] front = que.remove();
                boolean isMax = true;
                //한바퀴 돌면서 가장 큰 중요도 체크
                for(int q[]:que){
                    if(q[1] > front[1]){
                        isMax = false;
                        break;
                    }
                }
//                for(int j =0; j < que.size(); j++) {
//                    if (front[1] < (que.peek())[1]) {
//                        que.add(front);
//                        for(int k=0;k<j;k++){
//                            que.add(que.remove());
//                        }
//                        isMax = false;
//                        break;
//                    }
//                    que.add(que.remove());
//                }

                if(isMax){
                    printNum++;
                    if(front[0] == sel){
                        break;
                    }
                }else{
                    que.add(front);
                }
            }
            sb.append(printNum).append("\n");
        }
        System.out.print(sb);
    }
}
