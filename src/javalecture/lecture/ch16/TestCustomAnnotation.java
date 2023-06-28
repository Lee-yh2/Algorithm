package javalecture.lecture.ch16;

import java.lang.reflect.Method;

class Hello{
    @Student(firstName = "Ivaan", lastName = "Sagar", rollNo = 20)
    public void display(){
        System.out.println("Hello annotation");
    }
}

public class TestCustomAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        Hello h = new Hello();
        //h.display();
        Method m = h.getClass().getMethod("display");
        Student st = m.getAnnotation(Student.class);

        System.out.println("First name: " +st.firstName());
        System.out.println("Last name: " +st.lastName());
        System.out.println("Roll number: " +st.rollNo());
    }
}
