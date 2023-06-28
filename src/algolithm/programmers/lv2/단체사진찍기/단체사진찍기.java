package algolithm.programmers.lv2.단체사진찍기;

import java.util.HashMap;

public class 단체사진찍기 {
    HashMap<Character, Integer> map = new HashMap<>();
    boolean[] isVisit;
    int[] pos;
    int answer;

    public int solution(int n, String[] data) {
        isVisit = new boolean[8];
        pos = new int[8];
        answer = 0;

        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);

        bf(0, data);

        return answer;
    }

    public void bf(int depth, String[] data) {
        if (depth == 8) {
            if (check(data))
                answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (isVisit[i])
                continue;

            isVisit[i] = true;
            pos[depth] = i;
            bf(depth + 1, data);
            isVisit[i] = false;
        }
    }

    public boolean check(String[] data) {

        for (String str : data) {
            int a = pos[map.get(str.charAt(0))];
            int b = pos[map.get(str.charAt(2))];
            int res = Character.getNumericValue(str.charAt(4)) + 1;

            switch (str.charAt(3)) {
                case '=':
                    if (Math.abs(a - b) != res)
                        return false;
                    break;
                case '>':
                    if (Math.abs(a - b) <= res)
                        return false;
                    break;
                case '<':
                    if (Math.abs(a - b) >= res)
                        return false;
                    break;
            }
        }
        return true;
    }
}
