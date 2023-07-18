package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC_5430 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Deque<Integer> dq = new LinkedList<>();
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < size; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, dq);
        }
        System.out.println(sb);
    }

    static void AC(String command, Deque<Integer> dq) {
        boolean frontBack = true;
        for (char c : command.toCharArray()) {
            if (c == 'R') {
                frontBack = !frontBack;
            } else {
                if (dq.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }

                if (frontBack) {
                    dq.pollFirst();
                } else
                    dq.pollLast();
            }
        }

        sb.append("[");
        while (dq.size() > 1) {
            if (frontBack)
                sb.append(dq.pollFirst()).append(",");
            else
                sb.append(dq.pollLast()).append(",");
        }
        if (!dq.isEmpty())
            sb.append(dq.poll());
        sb.append("]").append("\n");
    }
}
