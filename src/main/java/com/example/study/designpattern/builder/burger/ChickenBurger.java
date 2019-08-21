package com.example.study.designpattern.builder.burger;

/**
 * 鸡肉汉堡
 *
 * @author lixiaoxiang
 */
public class ChickenBurger extends AbstractBurger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}