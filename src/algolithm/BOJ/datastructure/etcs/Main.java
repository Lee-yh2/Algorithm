package algolithm.BOJ.datastructure.etcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer command = new StringTokenizer(br.readLine()," ");

        int num = Integer.parseInt(command.nextToken());
        int k = Integer.parseInt(command.nextToken());
        for(int i = 1; i<=num; i++){
            list.add(i);
        }

        int idx = -1;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < k;j++){
                idx++;
                if(idx >= num){
                    idx = i;
                }
            }
            Collections.swap(list, i, idx);
            Collections.sort(list.subList(i+1, num));
        }
       sb.append("<");
        for(int i = 0; i<num;i++) {
            sb.append(list.get(i));
            if(i != num-1)
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
