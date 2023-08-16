package algolithm.programmers.random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class 문자열압축 {

    public static void main(String[] args) {
        System.out.println(new 문자열압축().solution("ababcdcdababcdcd"));
    }
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++) {
            int length = 0;
            String preS = s.substring(0, i);
            int sameCnt = 1;

            for (int j = i; j <= s.length()-i; j=j+i) {
                String curS = s.substring(j, j+i);

                if(preS.equals(curS)){
                    sameCnt++;
                }else{
                    String l = sameCnt + "";
                    length += sameCnt == 1?i:i+l.length();
                    sameCnt = 1;
                    preS = curS;
                }
            }
            String l = sameCnt + "";
            length += sameCnt == 1?i:i+l.length();

            // i개 단위로 다 나누어 지지 않을 때
            length += s.length()%i;

            answer = Math.min(answer, length);
        }

        return answer;
    }
}
