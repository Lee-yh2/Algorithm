package javalecture.homework.ch2;

public class HomeWork이윤형 {
    public static void main(String[] args) {
        short sa,sb,sc;
        sa = 1;
        sb = 2;

        //연산시 int로 자동 형변환이 되어서 short로 강제 형변환
        sc = (short)(sa+sb);
        System.out.println("sc:"+ sc);
    }
}
