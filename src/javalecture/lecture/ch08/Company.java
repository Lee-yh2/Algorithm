package javalecture.lecture.ch08;

public class Company {
    private static Company instance;
    private String name;

    //synchronized는 멀티 스레드시 동시에 명령을 실행해야할 때 기다리도록 한다
    public static synchronized Company getInstance() {
        if(instance == null){
            synchronized(Company.class) {
                instance = new Company();
            }
        }
        return instance;
    }

    private Company(){}
}

class CompanySingletonTest {
    public static void main(String argsp[]) {
        // 생성자 접근이 안된다
        // java: Company() has private access in javalecture.lecture.ch08.singleton.Company
        //Company c = new Company();
        Company c = Company.getInstance();
    }
}
