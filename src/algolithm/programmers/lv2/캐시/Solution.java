package algolithm.programmers.lv2.캐시;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680#
 */
public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize != 0) {
            cities = Arrays.stream(cities).map(s -> s.toLowerCase()).toArray(String[]::new);
            ArrayList<String> cache = new ArrayList<>();


            for (int i = 0; i < cities.length; i++) {
                // 이미 캐시에 포함되어 있을때(hit)
                if (cache.contains(cities[i])) {
                    cache.remove(cache.indexOf(cities[i]));
                    cache.add(cities[i]);
                    answer++;
                } else { // miss
                    if (cache.size() >= cacheSize)
                        cache.remove(0);
                    cache.add(cities[i]);
                    answer += 5;
                }
            }

        } else {
            answer = 5 * cities.length;
        }
        return answer;
    }
}
