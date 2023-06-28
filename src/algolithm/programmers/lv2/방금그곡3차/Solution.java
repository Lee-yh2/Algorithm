package algolithm.programmers.lv2.방금그곡3차;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683#
 */

public class Solution {
    public String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "";

        int maxPlayTime = 0;
        String answerMusic = "(None)";

        m = replaceMusic(m);
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");

            String sTime = st.nextToken();
            String eTime = st.nextToken();
            int playTime = diffMin(sTime, eTime);

            String musicName = st.nextToken();
            String music = st.nextToken();
            music = replaceMusic(music);

            String remixMusic = "";
            if(playTime > music.length()) {

                for (int j = 0; j < playTime/music.length(); j++) {
                    remixMusic += music;
                }

                remixMusic += music.substring(0, playTime % music.length());
            }else{
                remixMusic += music.substring(0, playTime);
            }

            if(remixMusic.contains(m)){
                if(playTime > maxPlayTime){
                    maxPlayTime = playTime;
                    answerMusic = musicName;
                }
            }
        }

        answer = answerMusic;

        return answer;
    }

    public String replaceMusic(String m){
        m = m.replaceAll("C#", "H");
        m = m.replaceAll("D#", "I");
        m = m.replaceAll("F#", "J");
        m = m.replaceAll("G#", "K");
        m = m.replaceAll("A#", "L");

        return m;
    }

    public static void main(String[] args) throws ParseException {

        System.out.println( new Solution().diffMin("23:50", "00:00"));
    }

    public int diffMin(String sTime, String eTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Date date1 = sdf.parse(sTime);
        System.out.println(date1);
        Date date2 = sdf.parse(eTime);
        System.out.println(date2);

        long timeMil1 = date1.getTime();
        long timeMil2 = date2.getTime();

        long diff = timeMil2 - timeMil1;

        long mDiff = diff / (1000*60);

        return Long.valueOf(mDiff).intValue();
    }
}
