package algolithm.BOJ.binarysearch.백준1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lengthList = new int[k];

        // int로 했더니 1 1 2147473647의 경우 아래에서 +1을 해주니 -2147483648이 되었다
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lengthList[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lengthList[i]);
        }

        long start = 1;
        long end = max; //그냥 최대값으로 해버리면 2 2 1 1의 경우 mid가 0이되어 에러가 뜬다
        long result = -1;
        while (start < end){
            long mid = (start + end)/2;

            int cnt = 0;
            for(int i = 0; i < lengthList.length; i++){
                cnt += lengthList[i]/mid;
            }

            if(cnt >= n){
                result = mid;
                start = mid + 1;
            }else{
                //mid-1로 할경우 mid가 0이되버릴 수 있다 ex) 4 8 4 2 1 1
                end = mid;
            }
        }
        System.out.println(result);
    }
}
