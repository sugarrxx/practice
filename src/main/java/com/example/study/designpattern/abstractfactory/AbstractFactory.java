package com.example.study.designpattern.abstractfactory;

/**
 * @author lixiaoxiang
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}