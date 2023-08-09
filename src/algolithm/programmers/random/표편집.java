package algolithm.programmers.random;

import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {
        String[] cmd = new String[]{"D 5","C","C"};
        System.out.printf(new 표편집().solution(8, 2, cmd));

    }
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        int t_size = n;
        Stack<Integer> trash = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            String command = cmd[i];
            String[] str = command.split(" ");
            if(str[0].equals("Z")){
                if(!trash.isEmpty()){
                    int recent = trash.pop();
                    t_size++;
                    if(recent <= k)
                        k++;
                }
            }else if(str[0].equals("C")){
                trash.add(k);
                t_size--;
                if (t_size <= k)
                    k--;
            }else {
                int x = Integer.parseInt(str[1]);
                if(str[0].equals("U"))
                    k -= x;
                else
                    k += x;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<t_size; i++)
            builder.append("O");
        while(!trash.isEmpty())
            builder.insert(trash.pop().intValue(), "X");
        answer=builder.toString();

        return answer;
    }
}
