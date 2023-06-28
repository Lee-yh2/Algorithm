package javalecture.lecture.ch14;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeEx3 {
    public static void main(String args[]){
        LocalTime present1 = LocalTime.now();
        System.out.println("현재 시각은 " +
                present1.getHour() + "시 " +
                present1.getMinute() + "분입니다.");

        LocalTime present2 = LocalTime.now();
        String ampm;
        if(present2.get(ChronoField.AMPM_OF_DAY) == 0) {
            ampm = "오전";
        } else {
            ampm = "오후";
        }
        System.out.println("지금은 " + ampm + " " +
                present2.get(ChronoField.HOUR_OF_AMPM) + "시입니다.");

        int a = present2.get(ChronoField.AMPM_OF_DAY);
        System.out.println(a);
    }
}