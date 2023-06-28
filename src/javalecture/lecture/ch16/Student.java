package javalecture.lecture.ch16;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Student {
    String firstName();
    String lastName();
    int rollNo();
}
