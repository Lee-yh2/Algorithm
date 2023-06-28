package algolithm.programmers.lv2.JadenCase문자열만들기;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
public class Solution {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String ss = new Solution().solution(s);
        System.out.println(ss);
    }

    public String solution(String s) {
        String answer = "";

        String[] list = s.toLowerCase().split(" ");

        for (int i = 0; i < list.length; i++) {
            String str = list[i];

            if (str.length() != 0)
                answer += str.substring(0, 1).toUpperCase() + str.substring(1);

            if (i != list.length - 1)
                answer += " ";

        }
        // s의 마지막 문자가 " " 일 경우 " "가 그대로 나와야 한다
        if (s.substring(s.length() - 1, s.length()).equals(" "))
            answer += " ";

        return answer;
    }
}
