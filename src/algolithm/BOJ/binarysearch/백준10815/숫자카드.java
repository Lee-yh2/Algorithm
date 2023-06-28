package algolithm.BOJ.binarysearch.백준10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int[] haveCartList = new int[n];
        for(int i = 0; i < n; i++){
            haveCartList[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int[] isCartList = new int[m];
        for(int i = 0; i < m; i++){
            isCartList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(haveCartList);

        for(int i = 0; i < m; i++) {
            int start = 0;
            int end = n;
            int result = 0;
            while (start < end) {
                int mid = (start + end) / 2;

                if(isCartList[i] > haveCartList[mid])
                    start = mid + 1;
                else if(isCartList[i] < haveCartList[mid])
                    end = mid;
                else if(isCartList[i] == haveCartList[mid]){
                    result = 1;
                    break;
                }
            }
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }
}
