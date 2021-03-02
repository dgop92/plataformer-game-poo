package main;

import core.GameSketch;
import core.ScreenSize;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //scren size may vary, it is customizable
        GameSketch g = new GameSketch();
        // g.setScreenSize(new ScreenSize(800, 800, 64));
        g.setScreenSize(new ScreenSize(768, 768, 64));
        g.run();
    }
}
