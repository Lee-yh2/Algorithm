package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1189
 */
public class 컴백홈 {
    static int r, c, k;
    static char[][] map;
    static boolean[][] isVisited;
    static int answer = 0;

    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        isVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                char m = str.charAt(j);
                map[i][j] = m;
                if(m == 'T')
                    isVisited[i][j] = true;
            }
        }

        isVisited[r-1][0] = true;
        dfs(1, r-1, 0);

        System.out.println(answer);

    }

    static void dfs(int depth, int sX, int sY){
        if(depth == k){
            if(sX == 0 && sY == c-1)
                answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = sX + dX[i];
            int nY = sY + dY[i];

            if(nX < 0 || nX >= r || nY < 0 || nY >= c)
                continue;

            if (isVisited[nX][nY])
                continue;

            isVisited[nX][nY] = true;
            dfs(depth+1, nX, nY);
            isVisited[nX][nY] = false;
        }
    }
}
