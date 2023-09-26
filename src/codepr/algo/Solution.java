package codepr.algo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getStaleServerCount' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY log_data
     *  3. INTEGER_ARRAY query
     *  4. INTEGER X
     */

    public static List<Integer> getStaleServerCount(int n, List<List<Integer>> log_data, List<Integer> query, int X) {
        List<Integer> answers = new ArrayList<>();

        Collections.sort(log_data, (a, b) -> a.get(1).compareTo(b.get(1)));

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < query.size(); i++) {
            int sTime = query.get(i) - X;
            int eTime = query.get(i);

            int s = 0;
            int e = log_data.size()-1;
            while(s <= e){
                if(log_data.get(s).get(1) < sTime){
                    s++;
                }

                if(log_data.get(e).get(1) > eTime){
                    e--;
                }

                if(log_data.get(s).get(1) >= sTime
                        && log_data.get(e).get(1) <= eTime){
                    break;
                }
            }
            set.clear();
            for (int j = s; j <= e; j++) {
                set.add(log_data.get(s).get(0));
            }

            answers.add(n - set.size());
        }

        return answers;

    }





}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int log_dataRows = Integer.parseInt(bufferedReader.readLine().trim());
        int log_dataColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> log_data = new ArrayList<>();

        IntStream.range(0, log_dataRows).forEach(i -> {
            try {
                log_data.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> query = IntStream.range(0, queryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.getStaleServerCount(n, log_data, query, X);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
