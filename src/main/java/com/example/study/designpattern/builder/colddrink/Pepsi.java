package com.example.study.designpattern.builder.colddrink;

/**
 * 百事可乐
 *
 * @author lixiaoxiang
 */
public class Pepsi extends AbstractColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}