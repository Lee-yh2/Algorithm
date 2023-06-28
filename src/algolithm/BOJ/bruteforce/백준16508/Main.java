package algolithm.BOJ.bruteforce.백준16508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
처음 실패 반례
AAA
3
10000 BCD
20000 AAC
50000 DDD
 */
public class Main {
    static final int ALPHABET_NUM = 26;
    static String[] tList;
    static int[] tPrice;
    static int[] tHaveChar = new int[ALPHABET_NUM];
    static int[] bookHaveChar = new int[ALPHABET_NUM];
    static String t;
    static int n, result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = br.readLine();
        n = Integer.parseInt(br.readLine());
        tList = new String[n];
        tPrice = new int[n];

        for(int i = 0; i < t.length(); i++)
            tHaveChar[t.charAt(i) - 'A']++;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            tPrice[i] = Integer.parseInt(st.nextToken());
            tList[i] = st.nextToken();
        }

        bp(0, 0);
        if(result == Integer.MAX_VALUE)
            result = -1;

        System.out.println(result);
    }

    public static void bp(int depth, int sum){
        if(depth == n){
            if(check())
                result = Math.min(sum, result);
            return;
        }
        for(int i = 0; i < tList[depth].length(); i++)
            bookHaveChar[tList[depth].charAt(i) - 'A']++; //책의 알파벳들만큼 증가
        bp(depth + 1, sum + tPrice[depth]);

        for(int i = 0; i < tList[depth].length(); i++)
            bookHaveChar[tList[depth].charAt(i) - 'A']--;
        bp(depth + 1, sum);
    }

    public static boolean check(){
        for(int i = 0; i < ALPHABET_NUM; i++){
            if(tHaveChar[i] > bookHaveChar[i]) //만드려는 알파벳이 책의 알파벳 보다 많으면 못만듬
                return false;
        }
        return true;
    }
}
