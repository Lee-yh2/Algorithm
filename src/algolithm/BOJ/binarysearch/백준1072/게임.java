package algolithm.BOJ.binarysearch.백준1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((double) y * 100 / x);

        int start = 0;
        int end = x; //x의 1%를 생각했는데 x가 100보다 작을때를 생각해서 x로둠 ex)x가 1일때
        int result = -1;
        while (start <= end) {
            if (z == 100) break;

            int mid = (start + end) / 2;
            int cal = (int) ((double) (y + mid) * 100 / (x + mid));

            if (z < cal) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
