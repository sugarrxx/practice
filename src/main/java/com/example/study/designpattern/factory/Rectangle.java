package com.example.study.designpattern.factory;

/**
 * @author lixiaoxiang
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}