package algolithm.BOJ.sorting.백준5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        List<String> phoneNum = new ArrayList<>();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNum = new String[n];
            for (int j = 0; j < n; j++) {
                phoneNum[j] = br.readLine();
            }

            Arrays.sort(phoneNum);
            boolean check = false;
            for(int j = 0; j < n - 1; j++){
                if(phoneNum[j+1].startsWith(phoneNum[j])){
                    check = true;
                    break;
                }
            }
            sb.append(check?"NO":"YES").append("\n");

//            Collections.sort(phoneNum, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1.length() - o2.length();
//                }
//            });
//
//            boolean check = false;
//            for (int j = 0; j < n; j++) {
//                String str = phoneNum.get(j);
//                for (int k = j + 1; k < n; k++) {
//                    if (str.length() == phoneNum.get(k).length())
//                        continue;
//                    if (phoneNum.get(k).startsWith(str)) {
//                        check = true;
//                        break;
//                    }
//                }
//                if(check) break;
//            }
//            sb.append(check?"NO":"YES").append("\n");
        }
        System.out.print(sb);
    }
}
