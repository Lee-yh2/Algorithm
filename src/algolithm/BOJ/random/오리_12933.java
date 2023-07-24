package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오리_12933 {
    static char[] cry = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] sounds = br.readLine().toCharArray();

        int answer = 0;
        if (sounds.length % 5 != 0 || sounds[0] != 'q')
            answer = -1;
        else {
            for (int i = 0; i < sounds.length - 5; i++) {
                if (sounds[i] == 'q') {
                    if (checkDuck(sounds, i)) {
                        answer++;
                    } else {
                        answer = -1;
                        break;
                    }
                }
            }

            for (int i = 0; i < sounds.length; i++) {
                if(sounds[i] != 'z'){
                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean checkDuck(char[] sounds, int start) {
        int curPoint = 0;
        for (int i = start; i < sounds.length; i++) {
            if (cry[curPoint] == sounds[i]) {
                curPoint++;
                sounds[i] = 'z';

                if (curPoint == 5)
                    curPoint = 0;
            }
        }
        return curPoint == 0 ? true : false;
    }
}
