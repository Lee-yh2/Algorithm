package algolithm.BOJ.sorting.백준7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] aList = new int[n];
            int[] bList = new int[m];

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++)
                aList[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++)
                bList[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(aList);
            Arrays.sort(bList);
            int cnt = 0;
            int curpoint = 0;
            int preNum = 0;
            int precnt = 0;

            for(int j = 0; j<aList.length; j++){
                //이전것과 크기가 같을때 그냥 이전에 더했던 cnt를 더해줌
                if(aList[j] == preNum) {
                    cnt += precnt;
                }else{
                    //curpoint라는 좌표를 정해 놓고 그 좌표부터 시작
                    //오름차순으로 정렬해둬서 그전의 까지의 값 cnt는 동일
                    cnt += precnt;
                    preNum = aList[j];
                    for(int k = curpoint; k < bList.length; k++){
                        if(aList[j] > bList[k]){
                            cnt++;
                            precnt++;
                            curpoint++;
                        }else{
                            break;
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
