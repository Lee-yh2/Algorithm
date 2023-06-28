package algolithm.programmers.lv2.가장큰정사각형찾기;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12905
 * 0 0 0 0 0
 * 0 0 1 1 1
 * 0 1 1 2 2
 * 0 1 2 2 3
 * 0 0 0 1 0
 *
 * 0
 * 1
 * 0
 *
 * 0 1 1
 */
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = board[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(dp[i][j] == 1){
                    // 상, 좌상, 좌 의 값을 비교
                    int min = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    min = Math.min(min, dp[i][j-1]);

                    dp[i][j] = min+1;
                    answer = Math.max(answer, min+1);
                }
            }
        }

        return answer*answer;
    }
}

// bfs 풀이 (효율성 테스트 탈락)
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Point{
//    int x, y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//class Solution
//{
//    int n, m;
//    int[][] isVisit;
//
//    int[] dirX = {1, 1, 0};
//    int[] dirY = {0, 1, 1};
//    public int solution(int [][]board)
//    {
//        int answer = 0;
//
//        n = board.length;
//        m = board[0].length;
//
//        for(int i = 0; i < n-1; i++){
//            for (int j = 0; j < m-1; j++) {
//                if(board[i][j] == 1){
//                    answer = Math.max(answer, bfs(i, j, board));
//                }
//            }
//        }
//
//        return answer*answer;
//    }
//
//    public int bfs(int a, int b, int[][] board){
//        Queue<Point> que = new LinkedList<>();
//
//        isVisit = new int[n][m];
//
//        que.add(new Point(a, b));
//        isVisit[a][b] = 1;
//        int size = 1;
//
//        while (!que.isEmpty()){
//            int curQueSize = que.size();
//
//            while (curQueSize-- > 0) {
//                Point p = que.poll();
//
//                for (int i = 0; i < 3; i++) {
//                    int x = p.x + dirX[i];
//                    int y = p.y + dirY[i];
//
//                    if (x < 0 || y < 0 || x >= n || y >= m)
//                        return size;
//
//                    if (board[x][y] != 1)
//                        return size;
//
//                    if (isVisit[x][y] != 1) {
//                        isVisit[x][y] = 1;
//                        que.add(new Point(x, y));
//                    }
//                }
//            }
//            size++;
//        }
//
//        return size;
//    }
//}