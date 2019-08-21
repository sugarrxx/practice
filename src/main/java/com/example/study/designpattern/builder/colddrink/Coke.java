package com.example.study.designpattern.builder.colddrink;

/**
 * 可口可乐
 *
 * @author lixiaoxiang
 */
public class Coke extends AbstractColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}