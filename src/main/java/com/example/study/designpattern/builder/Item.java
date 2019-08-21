package com.example.study.designpattern.builder;

/**
 * 食物条目
 *
 * @author lixiaoxiang
 */
public interface Item {
    String name();

    Packing packing();

    float price();
}