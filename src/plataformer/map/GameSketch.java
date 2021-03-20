package plataformer.map;

import plataformer.map.worlds.World;
import plataformer.enitties.alive.ControlablePlayer;
import processing.core.PApplet;

public class GameSketch extends PApplet{

    private ScreenSize screenSize;
    private World currwWord;

    @Override
    public void settings() {
        size(screenSize.getWidth(), screenSize.getHeight());
    }

    @Override
    public void setup() {
        currwWord = new World(this);
        currwWord.loadMap("data/test-map16.json");
    }

    @Override
    public void draw() {
        background(0);
        text(frameRate, 10, 10);
        currwWord.worldloop();
    }

    public void run() {
        String[] processingArgs = { this.getClass().getName() };
        PApplet.runSketch(processingArgs, this);
    }

    @Override
    public void keyPressed() {
        for (ControlablePlayer cp : currwWord.getControlablePlayers()) {
            cp.keyPressed(key);
        }
    }

    @Override
    public void keyReleased() {
        for (ControlablePlayer cp : currwWord.getControlablePlayers()) {
            cp.keyReleased();
        }
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    
}
