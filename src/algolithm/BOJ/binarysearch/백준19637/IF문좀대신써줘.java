package algolithm.BOJ.binarysearch.백준19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Title {
    String name;
    int maxSize;

    Title(String name, int maxSize) {
        this.name = name;
        this.maxSize = maxSize;
    }
}

public class IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Title[] titleList = new Title[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int maxSize = Integer.parseInt(st.nextToken());
            titleList[i] = new Title(name, maxSize);
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            int result = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (power > titleList[mid].maxSize) {
                    result = mid + 1;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sb.append(titleList[result].name).append("\n");
        }

        System.out.println(sb);
    }
}
