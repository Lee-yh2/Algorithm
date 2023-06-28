package algolithm.BOJ.backtracking.백준16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 로마숫자만들기 {
    static int n, cnt = 0;
    static int[] nums = {1, 5, 10, 50};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bt(0, 0, 0);
        System.out.println(cnt);
    }

    static void bt(int depth, int sum, int start){
        if(depth == n){
            if(!list.contains(sum) && sum != 0){
                list.add(sum);
                cnt++;
            }
            return;
        }
        for(int i = start; i < 4; i++) {
            bt(depth + 1, sum + nums[i], i);
        }
    }
}
