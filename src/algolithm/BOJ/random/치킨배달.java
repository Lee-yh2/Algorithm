package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static int[] select;
    static int answer = Integer.MAX_VALUE;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        select = new int[m];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int a = Integer.parseInt(st.nextToken());

                if (a == 1)
                    house.add(new Point(i, j));
                else if (a == 2)
                    chicken.add(new Point(i, j));
            }
        }

        checkMinPrice(0, 0);
        System.out.println(answer);
    }

    public static void checkMinPrice(int depth, int start) {
        if (depth == m) {
            int sumSt = 0;

            for (Point hPoint : house) {
                int temp = Integer.MAX_VALUE;
                for (int c : select) {
                    int dis = Math.abs(hPoint.x - chicken.get(c).x)
                            + Math.abs(hPoint.y - chicken.get(c).y);

                    temp = Math.min(temp, dis);
                }
                sumSt += temp;
            }

            answer = Math.min(answer, sumSt);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            select[depth] = i;
            checkMinPrice(depth + 1, i + 1);
        }
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
