package algolithm.BOJ.datastructure.num11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String inputStr = br.readLine();

        Stack<Character> stack = new Stack<>();
        int value = 1;
        for(int i =0; i < inputStr.length(); i++){
            char c = inputStr.charAt(i);
            if(c == '(' || c == '['){
                stack.push(c);
                value *= (c=='(')?2:3;
            }else if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '(' ){
                    result = 0;
                    break;
                }else if(inputStr.charAt(i-1) == '('){
                    result += value;
                }
                value /= 2;
            }else if(c ==']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    result = 0;
                    break;
                }else if(inputStr.charAt(i-1) == '['){
                    result += value;
                }
                value /= 3;
            }
        }
        if(!stack.isEmpty()) result = 0;
        System.out.println(result);
    }
}
