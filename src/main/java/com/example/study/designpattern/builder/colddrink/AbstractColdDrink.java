package com.example.study.designpattern.builder.colddrink;

import com.example.study.designpattern.builder.Bottle;
import com.example.study.designpattern.builder.Item;
import com.example.study.designpattern.builder.Packing;

/**
 * 实现Item的抽象类
 * 冷饮
 *
 * @author lixiaoxiang
 */
public abstract class AbstractColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}