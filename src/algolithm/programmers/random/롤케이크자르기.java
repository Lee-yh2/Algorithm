package algolithm.programmers.random;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        HashSet<Integer> lSet = new HashSet<>();
        HashMap<Integer, Integer> rMap = new HashMap<>();

        lSet.add(topping[0]);
        for(int i = 1; i < topping.length; i++){
            rMap.put(topping[i], rMap.getOrDefault(topping[i], 0)+1);
        }

        for(int i = 1; i < topping.length; i++){
            lSet.add(topping[i]);
            rMap.put(topping[i], rMap.get(topping[i])-1);

            if(rMap.get(topping[i]) == 0)
                rMap.remove(topping[i]);

            if(lSet.size() == rMap.size())
                answer++;
        }

        return answer;
    }
}
