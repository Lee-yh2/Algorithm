package algolithm.BOJ.datastructure.num06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int max_num = Integer.parseInt(br.readLine());
        int cur_sel = 0;
        for(int i = 0 ;i<max_num; i++) {
            int num = Integer.parseInt(br.readLine());
            if (cur_sel < num) {
                for(; cur_sel+1 <= num; cur_sel++){
                    stack.add(cur_sel+1);
                    sb.append("+").append("\n");
                }
            }else if(stack.peek() != num){
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
