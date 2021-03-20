package plataformer.map.tiles.main;

import plataformer.map.GameSketch;
import plataformer.map.ScreenSize;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //scren size may vary, it is customizable
        GameSketch g = new GameSketch();
        g.setScreenSize(new ScreenSize(768, 768, 48));
        // g.setScreenSize(new ScreenSize(768, 768, 64));
        g.run();
    }
}
