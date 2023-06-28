package algolithm.BOJ.datastructure.num13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower{
    int num;
    int hight;
    Tower(int num, int hight){
        this.num = num;
        this.hight = hight;
    }
}

public class 백준2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Tower> stackTower = new Stack<>();
        int towerNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<towerNum; i++){
           int hight = Integer.parseInt(st.nextToken());

           if(stackTower.isEmpty()){
               sb.append(0).append(" ");
               stackTower.push(new Tower(i+1, hight));
           }else{
               while (true){
                   if(stackTower.isEmpty()){
                       sb.append(0).append(" ");
                       stackTower.push(new Tower(i+1, hight));
                       break;
                   }
                   if(stackTower.peek().hight > hight){
                       sb.append(stackTower.peek().num).append(" ");
                       stackTower.push(new Tower(i+1, hight));
                       break;
                   }else{
                       stackTower.pop();
                   }
               }
           }
        }
        System.out.println(sb);
    }
}
