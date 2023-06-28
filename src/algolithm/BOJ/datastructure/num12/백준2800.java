package algolithm.BOJ.datastructure.num12;

import java.io.*;
import java.util.*;

public class 백준2800 {
    static List<int[]> brackets;
    static Set<String> result;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        brackets = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if(c == '(') {
                s.push(i);
            }else if(c == ')'){
                // )가 나오면 stack은 후입선출이기 때문에 마지막에 나온 (와 짝이 될수 있음
                brackets.add(new int[] {s.pop(), i});
            }
        }

        check = new boolean[line.length()]; //사용하는지 안하는지 check
        result = new TreeSet<>(); //treeSet을 사용하면 중복제거와 정렬도 자동으로 된다.
        comb(0, line.toCharArray());

        result.stream().forEach(System.out::println); //forEach = 코드를 반복 수행
    }

    static void comb(int depth, char[] str) {
        if(depth == brackets.size()) {
            boolean f = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length; i++) {
                if(!check[i]) {
                    sb.append(str[i]);
                } else f = true;
            }
            if(f) {
                result.add(sb.toString());
            }
            return;
        }

        comb(depth+1, str);

        int[] bracket = brackets.get(depth); //( )의 짝을 저장해둔 곳
        check[bracket[0]] = true;
        check[bracket[1]] = true;
        comb(depth+1, str);
        check[bracket[0]] = false;
        check[bracket[1]] = false;
    }
}

