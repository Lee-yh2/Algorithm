package algolithm.programmers.lv2.전화번호목록;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }


        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }

//        Arrays.sort(phone_book);
//
//        for (int i = 0; i < phone_book.length-1; i++) {
//                if(phone_book[i+1].startsWith(phone_book[i]))
//                    return false;
//        }
        return answer;
    }
}
