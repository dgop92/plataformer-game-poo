package main;

import java.awt.Rectangle;

import core.GameSketch;
import core.ScreenSize;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //This for testing
        Rectangle rect1 = new Rectangle(191, 492, 20, 20);
        Rectangle rect2 = new Rectangle(128, 512, 64, 64);

        System.out.println(rect1.intersects(rect2));
        System.out.println(Math.abs(rect2.getMaxX() - rect1.x));


        //scren size may vary, it is customizable
        GameSketch g = new GameSketch();
        // g.setScreenSize(new ScreenSize(800, 800, 32));
        g.setScreenSize(new ScreenSize(768, 768, 64));
        g.run();
    }
}
