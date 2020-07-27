package com.example.study.java.retention;


import java.lang.reflect.Method;

/**
 * @author lixiaoxiang
 */
public class MyTargetTest {

    @MyTarget(hello = "hi", world = "world", array = {}, style = int.class)
    public void doSomething() {
        System.out.println("do something");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = MyTargetTest.class.getMethod("doSomething");
        // 如果doSomething方法上存在注解@MyTarget，则为true
        if (method.isAnnotationPresent(MyTarget.class)) {
            System.out.println(method.getAnnotation(MyTarget.class));
        }
    }
}
