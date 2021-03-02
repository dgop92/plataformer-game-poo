package main;

import java.awt.Rectangle;

public class TestRectangle {
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Rectangle rect1 = new Rectangle(191, 492, 20, 20);
        Rectangle rect2 = new Rectangle(128, 512, 64, 64);
        
        Rectangle rect4 = new Rectangle(0, 0, 20, 20);
        Rectangle rect5 = new Rectangle(0, 10, 20, 20);

        Rectangle rectInter = rect4.intersection(rect5);
        System.out.println(rectInter); 
        System.out.println(rect1.intersects(rect2));
        System.out.println(Math.abs(rect2.getMaxX() - rect1.x));
    }
}
