package com.example.study.designpattern.factory;

/**
 * @author lixiaoxiang
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}