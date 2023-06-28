package algolithm.BOJ.binarysearch.백준2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] treeList = new int[n];
        int max = -1;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            treeList[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, treeList[i]);
        }

//        Arrays.sort(treeList);
        int result = 0;
        int start = 0, end = max; //treeList[treeList.length - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (treeList[i] > mid)
                    sum += (long)(treeList[i] - mid);
//                else
//                    break;
            }

            if (sum >= m) {
                result = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }

        System.out.println(result);
    }
}
