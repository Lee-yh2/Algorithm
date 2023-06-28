package algolithm.BOJ.bruteforce.백준14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int n, m;
    static int[][] paper;
    static boolean[][] visit;
    static int result = Integer.MIN_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visit[i][j] = true;
                bp(i, j, paper[i][j], 1);
                visit[i][j] = false;
            }
        }
        System.out.println(result);
    }

    static void bp(int row, int col, int sum, int depth){
        if(depth == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int curRow = row + dx[i];
            int culCol = col + dy[i];

            if(curRow < 0 || curRow >= n || culCol < 0 || culCol >= m)
                continue;

            if(!visit[curRow][culCol]){
                if(depth == 2){
                    visit[curRow][culCol] = true;
                    bp(row, col, sum + paper[curRow][culCol], depth+1);
                    visit[curRow][culCol] = false;
                }

                visit[curRow][culCol] = true;
                bp(curRow, culCol, sum + paper[curRow][culCol], depth+1);
                visit[curRow][culCol] = false;
            }
        }
    }

}
