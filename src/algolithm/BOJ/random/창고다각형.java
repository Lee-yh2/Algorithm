package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] towers = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            towers[i][0] = l;
            towers[i][1] = h;
        }

        Arrays.sort(towers, (a, b) -> {
            return a[0] - b[0];
        });
        int highest = 0;
        int highestPoint = 0;
        for (int i = 0; i < n; i++) {
            if(highest < towers[i][1]){
                highest = towers[i][1];
                highestPoint = i;
            }
        }

        int sum = 0;

        int height = 0;
        int moveCnt = 0;
        for (int i = 0; i <= highestPoint; i++) {
            if(height <= towers[i][1]){
                sum += (towers[i][0] - towers[moveCnt][0]) * height;
                height = towers[i][1];
                moveCnt = i;
            }
        }
        height = 0;
        moveCnt = 0;
        for (int i = n-1; i >= highestPoint; i--) {
            if(height <= towers[i][1]){
                sum += (towers[moveCnt][0] - towers[i][0]) * height;
                height = towers[i][1];
                moveCnt = i;
            }
        }

        sum += towers[highestPoint][1];

        System.out.println(sum);
    }
}
