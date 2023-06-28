package javalecture.homework.ch04;

public class Chapter4HomworkLeeYunHyung {
    public static void main(String[] args) {
        int starNum = 1;
        for(int i = 5; i > 0; i--){
            //공백 출력
            for(int k = 0; k < i-1; k++) {
                System.out.print(" ");
            }
            //별 출력
            for(int j = 0; j < starNum; j++){
                System.out.print("*");
            }
            starNum += 2;
            System.out.println();
        }
    }
}
