package algolithm.programmers.lv2.행렬의곱셈;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */
public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer;

        int n = arr1.length;
        int m = arr2[0].length;

        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
