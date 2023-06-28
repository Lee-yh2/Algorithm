package javalecture.lecture.ch13;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClassEx1 {
    public static void main(String args[]) {
        String str = "getClass() 메서드 실행";
        Class clazz = str.getClass();
        System.out.println("클래스명 : " + clazz.getName());
        System.out.println("상위 클래스명 : " + clazz.getSuperclass());
        System.out.println("메서드 목록");
        for(Method method : clazz.getMethods()){
            System.out.print(method.getName() + "\t");
        }
        System.out.println();
        System.out.println("필드 목록");
        for(Field field : clazz.getFields()){
            System.out.print(field.getName() + "\t");
        }
    }
}
