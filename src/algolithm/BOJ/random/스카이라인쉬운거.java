package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1863
 */
public class 스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            height[i] = y;
        }

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int h : height){
            while (!stack.isEmpty() && stack.peek() > h){
                answer++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == h)
                continue;

            stack.push(h);
        }

        System.out.print(answer);
    }
}
