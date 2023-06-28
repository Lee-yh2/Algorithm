package algolithm.BOJ.backtracking.백준1174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 줄어드는수 {
    //최대 줄어드는 수는 9876543210 다 순회 하려면 98억..
    static int n;
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        bt(0, 0);
        Collections.sort(list);

        System.out.println(list.size() < n ? "-1" : list.get(n - 1));
    }

    static void bt(int depth, long curNum) {
        if (!list.contains(curNum))
            list.add(curNum);

        if (depth >= 10)
            return;

        bt(depth + 1, (curNum * 10) + arr[depth]);
        bt(depth + 1, curNum);
    }
}
