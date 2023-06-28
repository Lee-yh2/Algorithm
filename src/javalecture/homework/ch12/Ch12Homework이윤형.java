package javalecture.homework.ch12;

public class Ch12Homework이윤형 {

      public static void main(String[] args) {
          try{
              scoreCal(103);
          } catch (ScoreErrorException e1){
              e1.printStackTrace();
              try{
                  scoreCal(50);
              }catch (ScoreErrorException e2){
                e2.printStackTrace();
                System.out.println("재시도 실패");
              }
          }finally {
              System.out.println("Heelo try~catch~finally!");
          }
      }

      static void scoreCal(int score) throws ScoreErrorException{
          if(score > 100 || score < 0)
              throw new ScoreErrorException("점수 오류입니다");
      }

}

class ScoreErrorException extends Exception {
    public ScoreErrorException(String message) {
        super(message);
    }
}