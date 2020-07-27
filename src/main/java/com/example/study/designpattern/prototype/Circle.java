package com.example.study.designpattern.prototype;

/**
 * @author lixiaoxiang
 */
public class Circle extends AbstractShape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}