package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잠수함식별_2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sound = br.readLine();

        System.out.println(sound.matches("(100+1+|01)+") ? "SUBMARINE" : "NOISE");
    }
}
