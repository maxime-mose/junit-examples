package examples.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJUnit {

    // Запускать только с тэгом "tag1".
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        var methods = MyTest.class.getDeclaredMethods();
        for (Method method : methods) {
            var testAnnotation = method.getAnnotation(Test.class);
            if (testAnnotation == null) {
                continue;
            }
            var tagAnnotation = method.getAnnotation(Tag.class);
            // ... логика
            method.invoke(new MyTest());
        }
    }
}
