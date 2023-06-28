package algolithm.programmers.lv2.점프와순간이동;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 *
 * 1 - 1    1
 * 2 - 1    10
 * 3 - 2    101
 * 4 - 1    100
 * 5 - 2    1001
 * 6 - 2    1010
 * 7 - 3    10101
 * 8 - 1    1000
 * 9 - 2    10001
 * 10 - 2   10010
 * 11 - 3   100101
 * 12 - 2   10100
 *
 *
 */
public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0){
            if(n%2 == 0)
                n /= 2;
            else{
                n--;
                ans++;
            }
        }
        return ans;
    }
}
