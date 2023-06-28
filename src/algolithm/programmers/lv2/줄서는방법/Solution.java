package algolithm.programmers.lv2.줄서는방법;

import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12936
 * 참고
 * https://cvillain.tistory.com/6
 */

public class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial += i;
            list.add(i);
        }




        return answer;
    }


    // n!가지라 안됨..
//    static ArrayList<int[]> list;
//    static int[] arr;
//    static boolean[] isVisit;
//    public int[] solution(int n, long k) {
//        int[] answer = {};
//        arr = new int[n];
//        isVisit = new boolean[n + 1];
//        list = new ArrayList<>();
//
//        bf(0, n);
//        answer = list.get((int)k-1);
//        return answer;
//    }
//
//    public void bf(int depth, int n){
//        if(depth == n){
//            list.add(arr);
//        }
//        for (int i = 1; i <= n; i++) {
//            if(isVisit[i])
//                continue;
//
//            arr[depth] = i;
//            isVisit[i] = true;
//            bf(depth+1, n);
//            isVisit[i] = false;
//        }
//    }
}
