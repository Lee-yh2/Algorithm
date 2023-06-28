package algolithm.BOJ.graphtraversal.백준10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
    static int[] rangeX = {-1,1,0,0};
    static int[] rangeY = {0,0,-1,1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        char[][] RGBList = new char[n][n];
        char[][] GBList = new char[n][n];
        boolean[][] RGBVisit = new boolean[n][n];
        boolean[][] GBVisit = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j =0; j < n; j++){
                char color = str.charAt(j);
                RGBList[i][j] = color;
                if(color == 'R')
                    GBList[i][j] = 'G';
                else
                    GBList[i][j] = color;
            }
        }

        int RGBCnt = 0;
        int GBCnt = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!RGBVisit[i][j]){
                    DFS(i, j, RGBList, RGBVisit);
                    RGBCnt++;
                }

                if(!GBVisit[i][j]){
                    DFS(i, j, GBList,GBVisit);
                    GBCnt++;
                }
            }
        }

        System.out.println(RGBCnt + " " + GBCnt);
    }

    static void DFS(int i, int j, char[][] list, boolean[][] visit){
        visit[i][j] = true;
        char color = list[i][j];

        for(int a = 0; a < 4; a++){
            int x = i + rangeX[a];
            int y = j + rangeY[a];

            if(x < 0 || x >= n || y < 0 || y >= n)
                continue;

            if(!visit[x][y] && color == list[x][y]){
                DFS(x, y, list, visit);
            }
        }

    }
}
