package tests;

import plataformer.map.GameSketch;
import plataformer.map.ScreenSize;

public class TestSketch {
    
    public static void main(String[] args) {
        
        GameSketch g = new GameSketch();
        // g.setScreenSize(new ScreenSize(800, 800, 64));
        g.setScreenSize(new ScreenSize(768, 768, 64));
        g.setScreenSize(new ScreenSize(768, 768, 48));
        // g.setScreenSize(new ScreenSize(768, 768, 64));
        g.run();
    }
}
