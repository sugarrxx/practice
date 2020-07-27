package com.example.study.designpattern.prototype;

/**
 * @author lixiaoxiang
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        AbstractShape clonedAbstractShape = (AbstractShape) ShapeCache.getShape("1");
        System.out.println("AbstractShape : " + clonedAbstractShape.getType());

        AbstractShape clonedAbstractShape2 = (AbstractShape) ShapeCache.getShape("2");
        System.out.println("AbstractShape : " + clonedAbstractShape2.getType());

        AbstractShape clonedAbstractShape3 = (AbstractShape) ShapeCache.getShape("3");
        System.out.println("AbstractShape : " + clonedAbstractShape3.getType());
    }
}