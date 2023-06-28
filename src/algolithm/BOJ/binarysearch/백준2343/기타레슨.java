package algolithm.BOJ.binarysearch.백준2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n*10000;
        while (start < end){
            int mid = (start + end)/2;

            if(cntCal(mid, list, m)){
                end = mid;
            }else
                start = mid + 1;
        }
        System.out.println(end);
    }

    static boolean cntCal(int mid, int[] list, int m){
        int cnt = 0;
        int seq = 0;
        int sum = 0;
        while (seq < list.length){
            if(sum + list[seq] <= mid) {
                sum += list[seq];
                seq++;
                if(seq == list.length)
                    cnt++;
            }else{
                cnt++;
                sum = 0;
            }

            if(cnt > m)
                return false;
        }
        return true;
    }
}
