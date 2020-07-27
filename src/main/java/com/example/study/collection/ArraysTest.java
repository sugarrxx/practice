package com.example.study.collection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author <a href="mailto:lixiaoxiang@vpgame.cn">lxx</a>
 * @date 2019-08-21
 */
public class ArraysTest {

    public static void main(String[] args) {
        int[] a = {1, 8, 2, 3, 4, 9, 5, 6, 7};



//        Arrays.fill(a, a.length - 1, a.length, 10);

//        Arrays.parallelSort(a);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));




//        System.out.println(Arrays.toString(a));

    }
}