package com.example.study.controller;

import java.util.Arrays;

/**
 * @author <a href="mailto:lixiaoxiang@vpgame.cn">lxx</a>
 * @date 2019-08-20
 */
public class ArraysTest {

    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) {
                min = values[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int minInteger = min(new Integer[]{1, 2, 3});//result:1
        double minDouble = min(new Double[]{1.2, 2.2, -1d});//result:-1d
//        String typeError = min(new String[]{"1","3"});//报错
    }
}
