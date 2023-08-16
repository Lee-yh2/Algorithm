package algolithm.programmers.random;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */
public class 괄호변환 {
    public String solution(String p) {
        String answer = changeStr(p);
        return answer;
    }

    public String changeStr(String p){
        // 1단계
        if(p.equals(""))
            return "";

        // 2단계 - u, v 분리
        String u = "";
        String v = "";

        int l = 0;
        int r = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(')
                l++;
            else
                r++;

            if(l == r){
                u = p.substring(0, i+1);

                if(i+1 < p.length())
                    v = p.substring(i+1);

                break;
            }
        }

        // 3단계 - u가 올바른 괄호문자열 이라면
        StringBuilder sb = new StringBuilder();

        if(checkStr(u)) {
            sb.append(u).append(changeStr(v));
        }else{ // 4단계 - 올바른 괄호문자열이 아니라면
            sb.append("(").append(changeStr(v)).append(")").append(reverseBracket(u));
        }

        return sb.toString();
    }

    // 4-5단계 - u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙이기
    public String reverseBracket(String u){
        String str = u.substring(1, u.length()-1);

        if(str.length() < 1)
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                sb.append(")");
            else
                sb.append("(");
        }

        return sb.toString();
    }

    public boolean checkStr(String u){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            if( u.charAt(i) == '('){
                stack.add('(');
            }else{
                if(stack.isEmpty())
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
