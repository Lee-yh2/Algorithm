package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/17615
 */
public class 볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int n = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();

        int rCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < n; i++) {
            if(balls[i] == 'R')
                rCnt++;
            else
                bCnt++;
        }

        int redMove = cntBalls('R', balls, rCnt, n);
        int blueMove = cntBalls('B', balls, bCnt, n);

        result = Math.min(redMove, blueMove);
        System.out.print(result);
    }

    public static int cntBalls(char color, char[] balls, int colorCnt, int n){
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(balls[i] == color)
                cnt++;
            else
                break;
        }
        int leftMove = colorCnt - cnt;

        cnt = 0;
        for (int i = n-1; i >= 0 ; i--) {
            if(balls[i] == color)
                cnt++;
            else
                break;
        }
        int rightMove = colorCnt - cnt;

        return Math.min(leftMove, rightMove);
    }
}
