package algolithm.programmers.lv2.위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < clothes.length; i++) {
            String clothType = clothes[i][1];

            if(map.containsKey(clothType)){
                map.put(clothType, map.get(clothType)+1);
            }else{
                map.put(clothType, 1);
                list.add(clothType);
            }
        }
        
        for(String s:list){
            answer *= map.get(s)+1; // 경우의수 구하기
        }

        return answer-1; // 전부 0일 경우는 제외
    }
}
