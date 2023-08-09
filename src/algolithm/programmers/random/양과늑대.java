package algolithm.programmers.random;

import java.util.ArrayList;
import java.util.List;

public class 양과늑대 {
    private static int answer;
    private static List<Integer>[] map;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        map = new List[info.length];
        for (int i = 0; i < info.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] edge:edges){
            map[edge[0]].add(edge[1]);
        }


        return answer;
    }
}
