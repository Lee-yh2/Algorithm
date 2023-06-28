package algolithm.BOJ.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MakeStack mStack = new MakeStack();

        int iterationNum = Integer.parseInt(br.readLine());
        for(int i=0; i < iterationNum; i++){
            String[] str = br.readLine().split(" ");
            printCommand(str, mStack);

        }
    }

    public static void printCommand(String[] Command, MakeStack mStack){
        switch (Command[0]){
            case "push":
                mStack.push(Integer.parseInt(Command[1]));
                break;
            case "pop":
                if(mStack.empty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(mStack.pop());
                }
                break;
            case "size":
                System.out.println(mStack.size());
                break;
            case "empty":
                System.out.println(mStack.empty() == true?1:0);
                break;
            case "top":
                if(mStack.empty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(mStack.top());
                }
                break;
            default:

        }
    }
}

class MakeStack{
    private ArrayList<Integer> stack = new ArrayList<>();

    public void push(int a){
        if(stack == null){
            stack = new ArrayList<>();
        }
        stack.add(a);
    }

    public int pop(){
        return stack.remove(stack.size()-1);
    }

    public int size(){
        return stack.size();
    }

    public boolean empty(){
        return stack.isEmpty();
    }

    public int top(){
        return stack.get(stack.size()-1);
    }
}