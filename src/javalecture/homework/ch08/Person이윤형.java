package javalecture.homework.ch08;

public class Person이윤형 {
    // 인스턴스 변수 정의
    // 성명
    // 돈 (소유한)
    private String name;
    private int money;

    // default 생성자 정의
    public Person이윤형(){}
    // 생성자 오버로딩 정의 (주문자명, 돈을 넘겨받아서) -> default 생성자를 호출한다
    public Person이윤형(String name, int money)
    {
        this();
        this.name = name;
        this.money = money;
    }

    public int getMoney() { return money; }

    public boolean useMoney(int money){
        if(this.money >= money) {
            this.money -= money;
            return true;
        }
        else{
            return false;
        }
    }
}
