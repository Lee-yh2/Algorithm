package algolithm.HackersRank.ClimbingTheLeaderboard;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
 */
class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> ranks = new ArrayList<>(new HashSet<>(ranked));
        Collections.sort(ranks, Collections.reverseOrder());
        for(int p : player){
            answer.add(findRank(ranks, p));
        }

        return answer;

    }

    public static int findRank(List<Integer> ranks, int player){
        int answer = 0;
        int left = 0;
        int right = ranks.size()-1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;

            if(ranks.get(mid) == player){
                answer = mid;
                break;
            }else if(ranks.get(mid) > player){
                answer = mid + 1;
                left = mid+1;
            }else if(ranks.get(mid) < player){
                answer = mid - 1;
                right = mid-1;
            }
        }

        if(ranks.get(mid) > player){
            answer = mid + 1;
        }else{
            answer = mid;
        }

        return answer+1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
