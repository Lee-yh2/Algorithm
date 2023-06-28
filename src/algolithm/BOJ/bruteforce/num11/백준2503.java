package algolithm.BOJ.bruteforce.num11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준2503 {
    static class GameQues{
        String num;
        int strike, ball;

        GameQues(String num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        GameQues[] quesData = new GameQues[n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            quesData[i] = new GameQues(num, strike, ball);
        }

        System.out.println(check(quesData));
    }

    public static int check(GameQues[] quesData){
        int result = 0;
        int quesNum = quesData.length;

        for(int i = 123; i <= 987; i++){
            if(!checkOverlap(i))
                continue;

            int passCount = 0;
            for(int j = 0; j<quesNum; j++){
                int strikeCount, ballCount = 0;

                strikeCount = checkStrikeCount(quesData[j], i);
                ballCount = checkBallCount(quesData[j], i);

                if(strikeCount == quesData[j].strike && ballCount == quesData[j].ball)
                    passCount++;
            }
            if(passCount == quesNum)
                result++;
        }

        return result;
    }

    private  static int checkBallCount(GameQues quesData, int num){
        int ballCount = 0;
        String str = Integer.toString(num);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j) continue;
                if(str.charAt(i) == quesData.num.charAt(j))
                    ballCount++;
            }
        }
        return ballCount;
    }

    private static int checkStrikeCount(GameQues quesData, int num){
        int strikeCount = 0;
        String str = Integer.toString(num);

            for(int i= 0; i < 3; i++){
                if (quesData.num.charAt(i) == str.charAt(i))
                    strikeCount++;
            }

        return strikeCount;
    }

    private static boolean checkOverlap(int num){
        String str = Integer.toString(num);
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }

        if(set.contains('0') || set.size() != 3 )
            return false;
        return true;
    }
}
