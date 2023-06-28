package algolithm.BOJ.twopointer.백준2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int[] isEat = new int[d+1];

        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        int L = 0;
        int R = k-1;
        int result = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = L; i <= R; i++) { //0~초밥 가짓수 까지의 배열을 만들고
            if(isEat[list[i]] == 0)    //중복되지 않으면 갯수 추가해주기
                cnt++;
            isEat[list[i]]++;
        }
        if(isEat[c] == 0)     //쿠폰 음식
            cnt++;
        isEat[c]++;

        while (L < n){
            result = Math.max(result, cnt);
            if(--isEat[list[L]] == 0) //--해줘서 0이된다는 말은 그 초밥은 이제 목록에 없다는 뜻
                cnt--;
            L++;
            R++;
            if(R >= n)
                R = 0;
            if(isEat[list[R]]++ == 0)
                cnt++;
        }
        System.out.print(result);
    }
}
