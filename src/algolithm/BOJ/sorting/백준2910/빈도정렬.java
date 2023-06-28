package algolithm.BOJ.sorting.백준2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Sortnum implements Comparable<Sortnum> {
    int cnt, firstSeq;

    Sortnum(int cnt, int firstSeq) {
        this.cnt = cnt;
        this.firstSeq = firstSeq;
    }

    @Override
    public int compareTo(Sortnum o) {
        if (cnt == o.cnt)
            return firstSeq - o.firstSeq;
        return o.cnt - cnt;
    }
}

public class 빈도정렬 {
    //필요한 것 숫자, 나온횟수, 처음 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Sortnum> map = new HashMap<>();
        //LinkedHashmap

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (!map.containsKey(a))
                map.put(a, new Sortnum(1, i));
            else {
                map.put(a, new Sortnum(map.get(a).cnt + 1, map.get(a).firstSeq));
            }
        }

        List<Integer> ketSet = new ArrayList<>(map.keySet());
        ketSet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return map.get(o1).compareTo(map.get(o2));
            }
        });

        for (int k : ketSet) {
            for (int i = 0; i < map.get(k).cnt; i++) {
                sb.append(k).append(" ");
            }
        }
        System.out.println(sb);
    }
}
