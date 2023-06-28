package algolithm.BOJ.bruteforce.백준1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder doc = new StringBuilder();
        StringBuilder word = new StringBuilder();

        doc.append(br.readLine());
        word.append(br.readLine());

        int count = 0;
        int index = 0;
        while ((index = doc.toString().indexOf(word.toString())) != -1) {
            doc.delete(0, index + word.length());
            count++;
        }

        System.out.print(count);
    }
}
