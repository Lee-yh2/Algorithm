package algolithm.programmers.lv2.영어끝말잇기;

import java.util.ArrayList;

/**
 * arrayList는 contains의 시간복잡도는 O(n)
 * HashSet은 O(1)
 * -> HashSet 쓰는게 좋았을것 같다
 */
public class Solution{
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int[] turnCnt = new int[n+1];
        ArrayList<String> list = new ArrayList<>();

        int turn = 2;
        turnCnt[1]++;
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            turnCnt[turn]++;

            if(list.contains(words[i]))
                break;

            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))
                break;

            list.add(words[i]);
            turn = turn==n?1:++turn;
        }

        if(list.size() != words.length){
            answer[0] = turn;
            answer[1] = turnCnt[turn];
        }

        return answer;
    }
}
