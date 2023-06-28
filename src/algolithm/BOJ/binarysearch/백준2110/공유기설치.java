package algolithm.BOJ.binarysearch.백준2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        for(int i =0; i<n;i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        int start = 0;
        int end = list[list.length-1];
        while (start < end){
            int mid = (start + end)/2;

            if(canInstall(mid, list) >= c){
                start = mid + 1;
            }else
                end = mid;
        }
        System.out.println(start - 1);
    }

    static int canInstall(int mid, int[] list){
        int cnt = 1;
        int preinstall = list[0];

        for(int i =1; i < list.length; i++){
            int install = list[i];

            if(install - preinstall >= mid){
                cnt++;
                preinstall = install;
            }
        }
        return cnt;
    }
}
