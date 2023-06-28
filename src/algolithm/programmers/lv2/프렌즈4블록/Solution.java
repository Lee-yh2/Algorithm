package algolithm.programmers.lv2.프렌즈4블록;

import java.util.Stack;

public class Solution {
    public static int[] dirX = {1, 1, 0};
    public static int[] dirY = {0, 1, 1};
    public char[][] reBoard;
    public boolean[][] isVisit;
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        reBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reBoard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            boolean isBomb = false;
            isVisit = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (reBoard[i][j] != '@') {
                        if (bombCheck(i, j)) {
                            isVisit[i][j] = true;
                            isVisit[i+1][j] = true;
                            isVisit[i][j+1] = true;
                            isVisit[i+1][j+1] = true;
                            isBomb = true;
                        }
                    }
                }
            }

            if(!isBomb)
                break;

            answer += bomb(m,n);
        }

        return answer;
    }

    public int bomb(int m, int n){
        int cnt = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 세로로 내려가며 제거해야 될 것은 빼고 stack에 담아주기
            for (int j = 0; j < m; j++) {
                if(!isVisit[j][i]){
                    stack.push(reBoard[j][i]);
                }else{
                    cnt++;
                }
            }

            //거꾸로 올라가며 스택에 있는 값들을 넣어주고 비었을때 @넣기
            for (int j = m-1; j >= 0; j--) {
                if(stack.isEmpty())
                    reBoard[j][i] = '@';
                else{
                    reBoard[j][i] = stack.pop();
                }
            }
        }

        return cnt;
    }

    public boolean bombCheck(int i, int j){
        boolean check = true;
        char c = reBoard[i][j];

        for (int k = 0; k < 3; k++) {
            int dX = i + dirX[k];
            int dY = j + dirY[k];

            if(c != reBoard[dX][dY]) {
                check = false;
                break;
            }
        }

        return check;
    }

}
