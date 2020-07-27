package com.example.study.designpattern.prototype;

/**
 * @author lixiaoxiang
 */
public class Rectangle extends AbstractShape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}