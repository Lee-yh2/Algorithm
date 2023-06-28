package algolithm.BOJ.backtracking.백준14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
    static int n;
    static int[] numList;
    static int[] calList, calSel;
    static boolean[] isUsed;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numList = new int[n];
        calList = new int[n-1];
        calSel = new int[n-1];
        isUsed = new boolean[n-1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < a; j++){
                calList[cnt] = i+1;
                cnt++;
            }
        }

        bt(0);
        System.out.println(maxNum);
        System.out.print(minNum);
    }

    static void bt(int depth){
        if(depth == n-1){
            maxNum = Math.max(cal(), maxNum);
            minNum = Math.min(cal(), minNum);
            return;
        }

        for(int i = 0; i < n-1; i++){
            if(isUsed[i]) continue;
            isUsed[i] = true;
            calSel[depth] = calList[i];
            bt(depth+1);
            isUsed[i] = false;
        }
    }

    static int cal(){
        int cal = 0;
        switch (calSel[0]){
            case 1:
                cal = numList[0] + numList[1];
                break;
            case 2:
                cal = numList[0] - numList[1];
                break;
            case 3:
                cal = numList[0] * numList[1];
                break;
            case 4:
                cal = numList[0] / numList[1];
                break;
        }
        for(int i = 2; i < n; i++){
            switch (calSel[i-1]){
                case 1:
                    cal = cal + numList[i];
                    break;
                case 2:
                    cal = cal - numList[i];
                    break;
                case 3:
                    cal = cal * numList[i];
                    break;
                case 4:
                    cal = cal / numList[i];
                    break;
            }
        }

        return cal;
    }


}
