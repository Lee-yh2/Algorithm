package algolithm.programmers.lv2.NQueen;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */
public class Solution {
    static int[] arr;
    static int cnt = 0;
    public int solution(int n) {
        arr = new int[n];
        bt(0, n);
        return cnt;
    }

    public void bt(int depth, int n){
        if(depth == n){
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if(check(depth))
                bt(depth+1, n);
        }
    }

    public boolean check(int depth){
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i])
                return false;

            if(Math.abs(arr[depth] - arr[i]) == Math.abs(depth - i))
                return false;
        }
        return true;
    }
}
