package algolithm.BOJ.bruteforce.num18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2961 {
    static Ingredient[] ingred;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    static class Ingredient{
        int s, b;
        Ingredient(int s, int b){
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ingred = new Ingredient[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ingred[i] = new Ingredient(s, b);
        }

        compareIngred(0);
        System.out.println(result);
    }

    static void compareIngred(int depth){
        if(depth == ingred.length){
            int sour = 1;
            int bitter = 0;
            int visitCount = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    visitCount++;
                    sour *= ingred[i].s;
                    bitter += ingred[i].b;
                }
            }
            if(visitCount == 0) return;
            if(result > Math.abs(sour-bitter))
                result = Math.abs(sour-bitter);
            return;
        }
        visited[depth] = true;
        compareIngred(depth +1);
        visited[depth] = false;
        compareIngred(depth +1);
    }
}
