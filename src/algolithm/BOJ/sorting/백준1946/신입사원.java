package algolithm.BOJ.sorting.백준1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Rank implements Comparable<Rank> {
    int aRank, bRank;
    Rank(int aRank, int bRank){
        this.aRank = aRank;
        this.bRank = bRank;
    }

    @Override
    public int compareTo(Rank o) {
        return this.aRank - o.aRank;
    }
}
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            Rank[] rank = new Rank[n];
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rank[j] = new Rank(a, b);
            }

            Arrays.sort(rank);
            sb.append(countN(rank, n)).append("\n");
        }
        System.out.println(sb);
    }

    static int countN(Rank[] rank, int n){
        int cnt = 0;
        int max = rank[0].bRank;
        for(int i = 0; i < n; i++){
            if(max >= rank[i].bRank){
                cnt++;
                max = rank[i].bRank;
            }
        }
        return cnt;
    }
}
