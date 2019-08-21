package com.example.study.designpattern.builder.burger;

import com.example.study.designpattern.builder.Item;
import com.example.study.designpattern.builder.Packing;
import com.example.study.designpattern.builder.Wrapper;

/**
 * 实现Item的抽象类
 * 汉堡
 *
 * @author lixiaoxiang
 */
public abstract class AbstractBurger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}