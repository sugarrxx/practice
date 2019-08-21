package com.example.study.designpattern.builder;

/**
 * 实现 Packing
 * 瓶装
 *
 * @author lixiaoxiang
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}