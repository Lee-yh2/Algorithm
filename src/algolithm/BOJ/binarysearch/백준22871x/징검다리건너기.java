package algolithm.BOJ.binarysearch.백준22871x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            Math.max(max,list[i]);
            Math.min(min,list[i]);
        }

        long start = 0;
        long end = (n-1)*(1+Math.abs(max-min));
        long result = 0;
        while (start <= end){
            long mid = (start + end)/2;

            if(check(mid, list)){
                result = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
    static boolean check(long mid, int[] list){
        int a =0;
        int jump = 1;
        while(a < list.length){
            if(a+jump >= list.length) return false;

            if((long)jump*(1+Math.abs(list[a]-list[a+jump])) > mid){
                jump++;
            }else{
                a += jump;
                jump = 1;
            }

            if(a == list.length - 1) break;
        }
        return true;
    }
}
