package com.example.study.designpattern.builder.burger;


/**
 * 牛肉汉堡
 *
 * @author lixiaoxiang
 */
public class BeefBurger extends AbstractBurger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Beef Burger";
    }
}