package algolithm.BOJ.graphtraversal.백준7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시간복잡도 O(n*m)
 */

class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 토마토 {
    static int n, m;
    static int [][] box;
    static int [][] dayCheck;

    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        dayCheck = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dayCheck[i], -1);
        }
        boolean isPerfect = true;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] != 1)
                    isPerfect = false;
            }
        }

        int result = -1;
        if(isPerfect)
            result = 0;
        else {
            bfs();
            result = checkResult();
        }
        System.out.println(result);
    }

    static void bfs(){
        Queue<Node> que = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 1) {
                    que.offer(new Node(i, j));
                    dayCheck[i][j]++;
                }else if(box[i][j] == -1){
                    dayCheck[i][j]++;
                }
            }
        }

        while (!que.isEmpty()){
            Node node = que.poll();

            for(int i = 0; i < 4; i++){
                int dX = node.x + dirX[i];
                int dY = node.y + dirY[i];

                if(dX < 0 || dX >= n || dY < 0 || dY >= m)
                    continue;

                if(box[dX][dY] == 0){
                    que.offer(new Node(dX, dY));
                    box[dX][dY] = 1;
                    dayCheck[dX][dY] = dayCheck[node.x][node.y] + 1;
                }
            }
        }
    }

    static int checkResult(){
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dayCheck[i][j] == -1) {
                    return -1;
                }
                max = Math.max(dayCheck[i][j], max);
            }
        }
        return max;
    }
}
