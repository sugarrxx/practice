package com.example.study.designpattern.abstractfactory;

/**
 * @author lixiaoxiang
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}