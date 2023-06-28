package algolithm.programmers.lv2.압축3차;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("KAKAO").toString());
    }

    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A'+ i)), i+1);
        }

        for (int i = 0; i < msg.length(); i++) {
            String str = msg.charAt(i)+"";
            int index = i+1;

            while (true){
                if(index > msg.length())
                    break;

                if(index == msg.length()){
                    list.add(map.get(msg.substring(i)));
                    i = index;
                    break;
                }

                String sumStr = msg.substring(i, index+1);
                if(map.containsKey(sumStr)){
                    index++;
                }else{
                    str = msg.substring(i, index);
                    list.add(map.get(str));
                    map.put(sumStr, map.size()+1);
                    i = index - 1;
                    break;
                }
            }
        }

        return list.stream().mapToInt(n -> n.intValue()).toArray();
    }
}
