package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 수학숙제_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                String match = matcher.group();
                match = match.replaceAll("^0+", "");
                result.add(match.length() == 0 ? "0" : match);
            }
        }

        result.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
        for(String s : result)
            sb.append(s).append('\n');

        System.out.println(sb);
    }
}
