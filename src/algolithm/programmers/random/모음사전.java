package algolithm.programmers.random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *
 * AEIOU
 * 1    A
 * 2    AA
 * 3    AAA
 * 4    AAAA
 * 5    AAAAA
 * 6    AAAAE
 * 7    AAAAI
 * 8    AAAAO
 * 9    AAAAU
 * 10   AAAE
 * 11   AAAEA
 * 12   AAAEE
 * 13   AAAEI
 * 14   AAAEO
 * 15   AAAEU
 * 16   AAAI
 * 17   AAAIA
 * 18   AAAIE
 * 19   AAAII
 * 20   AAAIO
 * 21   AAAIU
 * 22   AAAO
 * 23   AAAOA
 * 24   AAAOE
 * 25   AAAOI
 * 26   AAAOO
 * 27   AAAOU
 * 28   AAAU
 * 29   AAAUA
 * 30   AAAUE
 * 31   AAAUI
 * 32   AAAUO
 * 33   AAAUU
 * 34   AAE
 * 35   AAEA
 * 36   AAEAA
 */
public class 모음사전 {
    static int cnt = 0;
    static int answer = 0;
    static boolean end = false;

    public static void main(String[] args) {
        System.out.println(new 모음사전().solution("AAAAE"));
    }
    public int solution(String word) {
        String[] arr = {"A", "E", "I", "O", "U"};
        bf(0, word, "", arr);
        return answer;
    }

    public void bf(int depth, String word, String curStr, String[] arr){
        if(!end) {
            if (word.equals(curStr)) {
                answer = cnt;
                end = true;
                return;
            }

            if (depth == 5)
                return;

            for (int i = 0; i < 5; i++) {
                cnt++;
                bf(depth + 1, word, curStr + arr[i], arr);
            }
        }
    }
}
