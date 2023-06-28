package algolithm.programmers.lv2.올바른괄호;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push('(');
            else{
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }

        if(answer){
            answer = stack.isEmpty()?true:false;
        }

        return answer;
    }
}
