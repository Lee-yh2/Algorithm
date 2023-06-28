package algolithm.programmers.lv2.가장큰수;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (a, b)->{
            return (b+a).compareTo(a+b);
        });

        StringBuilder sb = new StringBuilder();
        for(String str : nums){
            sb.append(str);
        }

        answer = sb.charAt(0) == '0'?"0": sb.toString();

        return answer;
    }
}
