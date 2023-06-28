package algolithm.BOJ.bruteforce.num10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준16439 {
    static int count, result;
    static int[][] satis;
    static HashSet<Integer> checkSet = new HashSet<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        satis = new int[n][m];

       for(int i = 0; i<n; i++){
           st = new StringTokenizer(br.readLine()," ");
           for(int j = 0; j<m; j++) {
               satis[i][j] = Integer.parseInt(st.nextToken());
           }
       }
       maxCal(0, 0);
       System.out.println(result);
    }

    static void maxCal(int depth, int sum){
        if(depth == n){
            if(result < sum){
                result = sum;
            }
        }else{
            if(checkSet.size() >= 3){
                int max = 0;
                for(int i:checkSet){
                    if(max < satis[depth][i]) max = i;
                }
                maxCal(depth + 1, sum + satis[depth][max]);
            }else {
                for (int i = 0; i < m; i++) {
                    checkSet.add(i);
                    maxCal(depth + 1, sum + satis[depth][i]);
                    checkSet.remove(i);
                }
            }
        }
    }
}
