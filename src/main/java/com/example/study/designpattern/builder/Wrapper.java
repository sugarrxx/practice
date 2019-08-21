package com.example.study.designpattern.builder;


/**
 * 实现 Packing
 * 盒装
 *
 * @author lixiaoxiang
 */
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}