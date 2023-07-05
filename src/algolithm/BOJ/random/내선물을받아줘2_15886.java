package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 내선물을받아줘2_15886 {
    public static HashSet<Integer> present = new HashSet<>();
    public static char[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        road = new char[n];
        road = str.toCharArray();

        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[n];
            dfs(i, isVisited);
        }

        System.out.println(present.size());
    }

    public static void dfs(int idx, boolean[] isVisited){
        if(present.contains(idx))
            return;
        if(isVisited[idx]){
            present.add(idx);
            return;
        }

        isVisited[idx] = true;
        if(road[idx] == 'E')
            dfs(idx+1, isVisited);
        else
            dfs(idx-1, isVisited);
    }
}
