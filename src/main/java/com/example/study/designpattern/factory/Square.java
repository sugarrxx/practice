package com.example.study.designpattern.factory;

/**
 * @author lixiaoxiang
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}