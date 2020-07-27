package com.example.study.java.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyTarget {
    String hello() default "hello";

    String world();

    int[] array() default {2, 4, 5, 6};

    Class style() default String.class;
}
