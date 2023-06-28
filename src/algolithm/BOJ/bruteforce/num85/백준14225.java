package algolithm.BOJ.bruteforce.num85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 백준14225 {
    static int[] sequence;
    static int n;
    static Set<Integer> setSumNum = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        sequence = new int[n];
        for(int i = 0; i < n; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        sumFind(0, 0);
        System.out.println(minFind());
    }
    public static int minFind(){
        int result = 0;
        for(int i = 1; i<= 2000000; i++){
            if(setSumNum.contains(i)){
                continue;
            }
            result = i;
            break;
        }
        return result;
    }

    public static void sumFind(int depth, int sum){
        if(depth == n){
           if(sum>0)
            setSumNum.add(sum);
           return;
        }
        sumFind(depth +1, sum + sequence[depth]);
        sumFind(depth +1, sum);
    }
}
