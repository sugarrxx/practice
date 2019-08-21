package com.example.study.designpattern.builder;

import com.example.study.designpattern.builder.burger.BeefBurger;
import com.example.study.designpattern.builder.burger.ChickenBurger;
import com.example.study.designpattern.builder.colddrink.Coke;
import com.example.study.designpattern.builder.colddrink.Pepsi;

/**
 * 实际的 builder 类负责创建 Meal 对象
 *
 * @author lixiaoxiang
 */
public class MealBuilder {

    public Meal prepareBeefMeal() {
        Meal meal = new Meal();
        meal.addItem(new BeefBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}