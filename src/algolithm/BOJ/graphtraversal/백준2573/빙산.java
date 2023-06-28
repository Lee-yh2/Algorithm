package algolithm.BOJ.graphtraversal.백준2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산 {
    static int n, m;
    static int[][] map;
    static int[][] canVisit;
    static int[][] melt;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        canVisit = new int[n][m];
        melt = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int years = 0;
        while (true){
            setCanVisit();

            int cnt = 0;
            for(int i = 1; i < n-1; i++){
                for(int j = 1; j < m-1; j++){
                    if(canVisit[i][j] == 1){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            if(cnt >= 2)
                break;
            else if(cnt == 0){
                years = 0;
                break;
            }

            meltIce();
            years++;
        }

        System.out.print(years);
    }

    static void dfs(int x, int y){
        canVisit[x][y] = 2;

        for(int i = 0; i < 4; i++){
            int dX = x + dirX[i];
            int dY = y + dirY[i];

            if(dX < 0 || dX >= n || dY < 0 || dY >= m)
                continue;

            if(canVisit[dX][dY] == 0)
                melt[x][y]++;

            if(canVisit[dX][dY] == 1)
                dfs(dX,dY);
        }
    }

    static void meltIce(){
        for(int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                map[i][j] = Math.max((map[i][j] - melt[i][j]), 0);

                canVisit[i][j] = 0;
                melt[i][j] = 0;
            }
        }

    }

    static void setCanVisit(){
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(map[i][j] != 0){
                    canVisit[i][j] = 1;
                }
            }
        }
    }
}
