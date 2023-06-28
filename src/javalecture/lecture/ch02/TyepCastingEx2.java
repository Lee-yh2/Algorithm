package javalecture.lecture.ch02;

public class TyepCastingEx2 {
    public static void main(String args[]) {
//        double douVal  = 35.3;
//        int score = (int)douVal; // 강제 캐스팅으로 소수점 절사
//
//        System.out.println("int score="+score);
//        System.out.println("double douVal="+douVal);
//
//        byte b = 10;
//        int i = b; // up-casting
//        System.out.println("byte b : " + b + ", int i : " + i);
//
//        int i2 = 300;
//        byte b2 = (byte)i2; // down-casting
//        System.out.println("int i2 : " + i2 + ", byte b2 : " + b2);
//
//        int n1 = 123;
//        double d1 = n1;  // 정수를 실수로 바꿀때에는 캐스팅이 필요없다.
//        System.out.println(d1);  // 123.0 출력
//
//        double d2 = 123.456;
//        int n2 = (int) d2; // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅해 주어야 한다.
//        System.out.println(n2);  // 소숫점이 생략된 123 출력

        // 과제 : 오류나는 코드를 정상적으로 동작하도록 수정하고, 이렇게 해야하는 이유를 작성
        short sa,sb,sc;
        sa = 1;
        sb = 2;
        // incompatible types: possible lossy conversion from int to short
        sc = (short)(sa+sb);
        System.out.println("sc:"+ sc);
    }
}
