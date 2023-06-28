package algolithm.BOJ.sorting.백준2776x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Note implements Comparable<Note> {
    int a, b;
    Note(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Note o) {
        return b - o.b;
    }
}
public class 암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] result = null;
        int[] list1 = null;
        Note[] list2 = null;
        int n, m;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            list1 = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                list1[j] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());
            list2 = new Note[m];
            result = new int[m];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                list2[j] = new Note(j, Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(list1);
            Arrays.sort(list2);
            int sel = 0;
            for(int a:list1){
                if(sel == list2.length)
                    break;
                for(int j = sel; j< list2.length; j++) {
                    if (a > list2[j].b)
                        sel++;
                    else
                        break;
                }
                if(a == list2[sel].b){
                    result[list2[sel].a] = 1;
                    sel++;
                }
            }

            for(int a:result)
                sb.append(a).append("\n");
        }

        System.out.println(sb);
    }
}
