package javalecture.homework.ch08;

public class MenuOrder이윤형 {
    // 사람 객체와 메뉴를 주문한다
    // 메뉴오더 객체를 생성해서 메뉴를 주문하고 메뉴와 구매 후 잔액 차감 처리
    // 잔액이 부족할 경우 메시지 출력
    public static void main(String[] args) {
        Person이윤형 person = new Person이윤형("Lee",10000 );
        order("coffee", person);

    }

    public static void order(String menu, Person이윤형 person){
        System.out.println(menu+"를 주문하셨습니다!");
        int price = 0;
        switch (menu){
            case "coffee":
                price = Menu이윤형.coffee;
                break;
            case "icetea":
                price = Menu이윤형.icetea;
                break;
            case "bread":
                price = Menu이윤형.bread;
                break;
            default:
                System.out.println("없는 메뉴입니다!");
                return;
        }
        if(person.useMoney(price)){
            System.out.println("잔액은 : "+ person.getMoney() +"입니다!");
        } else{
            System.out.println("잔액이 부족합니다!");
        }
    }
    /*
    정상주문
    커피를 주문하셨습니다!
    잔액은 : 9000입니다!
    잔액부족
    커피를 주문하셨습니다!
    잔액이 부족합니다!
     */
}
