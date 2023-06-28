package algolithm.BOJ.datastructure.num07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(br.readLine());
        String inputFormula = br.readLine();

        double[] dNum = new double[inputNum];
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < inputNum; i++){
            dNum[i] = Double.parseDouble(br.readLine());
        }

        for(int i =0; i<inputFormula.length(); i++){
            if(inputFormula.charAt(i) >= 'A' && inputFormula.charAt(i) <= 'Z'){
                stack.push(dNum[inputFormula.charAt(i) - 'A']);
            }else{
                double firstNum = stack.pop();
                double secondNum = stack.pop();
                switch (inputFormula.charAt(i)){
                    case '+':
                        stack.push(secondNum+firstNum);
                        break;
                    case '-':
                        stack.push(secondNum-firstNum);
                        break;
                    case '*':
                        stack.push(secondNum*firstNum);
                        break;
                    case '/':
                        stack.push(secondNum/firstNum);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
