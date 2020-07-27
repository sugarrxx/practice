package com.example.study.designpattern.prototype;

/**
 * @author lixiaoxiang
 */
public class Square extends AbstractShape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}