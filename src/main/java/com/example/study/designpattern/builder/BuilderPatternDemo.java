package com.example.study.designpattern.builder;

/**
 * 测试
 *
 * @author lixiaoxiang
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal beefMeal = mealBuilder.prepareBeefMeal();
        System.out.println("Beef Meal");
        beefMeal.showItems();
        System.out.println("Total Cost: " + beefMeal.getCost());

        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        System.out.println("Chicken Meal");
        chickenMeal.showItems();
        System.out.println("Total Cost: " + chickenMeal.getCost());
    }
}