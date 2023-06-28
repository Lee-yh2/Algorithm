package algolithm.BOJ.graphtraversal.백준1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳 {
    static char[][] list;
    //static Stack<Character> isVisit = new Stack<>();
    static boolean[] isVisit = new boolean[26];
    static int r, c, max = Integer.MIN_VALUE;

    static int[] dirX = {-1,1,0,0};
    static int[] dirY = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        list = new char[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for(int j = 0; j < c; j++){
                list[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt){
        if(isVisit[list[x][y] - 'A']){
            max = Math.max(max, cnt);
            return;
        }

        isVisit[list[x][y] - 'A'] = true;
        for(int i = 0; i < 4; i++){
            int dX = x + dirX[i];
            int dY = y + dirY[i];

            if(dX < 0 || dX >= r || dY < 0 || dY >= c)
                continue;

            dfs(dX,dY,cnt + 1);
        }
        isVisit[list[x][y] - 'A'] = false;
    }
}
