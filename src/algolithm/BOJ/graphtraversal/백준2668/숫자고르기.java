package algolithm.BOJ.graphtraversal.백준2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 숫자고르기 {
    static int n;
    static int[] table;
    static boolean[] isVisit;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        table = new int[n + 1];
        isVisit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < n+1; i++){
            isVisit[i] = true;
            dfs(i, i);
            isVisit[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int a: list)
            sb.append(a).append("\n");

        System.out.print(sb);
    }

    static void dfs(int start, int end){
        if(!isVisit[table[start]]){
            isVisit[table[start]] = true;
            dfs(table[start], end);
            isVisit[table[start]] = false;
        }

        if(table[start] == end)
            list.add(end);
    }
}
