package algolithm.BOJ.bruteforce.num19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2615 {
    static int[][] goStone = new int[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i = 0; i < 19; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 19; j++){
                goStone[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int w = 0; w < 19; w++){
            for(int h = 0; h < 19; h++){
                if(goStone[w][h] == 0)
                    continue;


            }
        }
    }

    public static boolean widthCheck(int w, int h){
        boolean check = false;

        for(int i = 0; i < 6; i++){
            if(h+i >= 19)
                break;
        }
        return check;

    }
    public static boolean heightCheck(int w, int h){
        boolean check = false;

        return check;
    }
    public static boolean diagonalCheck(int w, int h){
        boolean check = false;

        return check;
    }
}
