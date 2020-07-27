package com.example.study;

import com.example.study.utils.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracticeApplicationTests {

    @Test
    public void contextLoads() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }

    @Test
    public void test() {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 4, 5);

        List<Integer> reduce1 = list1.stream().filter(item -> !list2.contains(item))
                .collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out::println);

        List<Integer> reduce2 = list2.stream().filter(item -> !list1.contains(item))
                .collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce2.parallelStream().forEach(System.out::println);
    }

    @Test
    public void test1() throws ParseException {
        String date = "20200217T220401.000Z";
        date = date.replace("Z", " UTC");
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSS Z");
        Date d = format.parse(date);
        System.out.println(d);
        Date date1 = new Date();
        System.out.println(date1);
    }



}
