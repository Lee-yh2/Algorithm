package javalecture.homework.ch07;

public class MethodConstructorOverrodingHomework이윤형 {
    int id;
    String name;
    int age;

    // 생성자 오버로딩 구현
    MethodConstructorOverrodingHomework이윤형(){}
    MethodConstructorOverrodingHomework이윤형(int id, String name){
        this.id = id;
        this.name = name;
    }
    MethodConstructorOverrodingHomework이윤형(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    // 메서드 오버로딩 구현
    void showInformation(int i){
        System.out.println(i);
    }

    void showInformation(float f){
        System.out.println(f);
    }

    void showInformation(float f, int i, double d){
        System.out.println(f+" "+i+" "+d);
    }

    void showInformation(String str, Long l, double d){
        System.out.println(str+" "+l+" "+d);
    }


    public static void main(String args[]){
        MethodConstructorOverrodingHomework이윤형 m = new MethodConstructorOverrodingHomework이윤형();
        MethodConstructorOverrodingHomework이윤형 m1 = new MethodConstructorOverrodingHomework이윤형(111,"홍길동");
        MethodConstructorOverrodingHomework이윤형 m2 = new MethodConstructorOverrodingHomework이윤형(222,"김수철",25);

        m.showInformation(10);
        m1.showInformation(1.2f);
        m2.showInformation(3.8f, 10, 2.0);
        m1.showInformation("홍길동", 10L, 2.0);
        m.showInformation(1);
    }
}
