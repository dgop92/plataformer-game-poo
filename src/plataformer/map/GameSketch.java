package plataformer.map;

import javax.swing.JFrame;

import interfaces.GUIUtils;
import interfaces.MainMenu;
import plataformer.entities.alive.ControlablePlayer;
import plataformer.map.worlds.World;
import plataformer.map.worlds.WorldGrass1;
import plataformer.map.worlds.WorldGrass2;
import plataformer.map.worlds.WorldBrick1;
import plataformer.map.worlds.WorldBrick2;
import processing.core.PApplet;

import processing.awt.PSurfaceAWT.SmoothCanvas;

public class GameSketch extends PApplet{

    private ScreenSize screenSize;
    private World currwWord;
    int worldNumber = 1;

    @Override
    public void settings() {
        size(screenSize.getWidth(), screenSize.getHeight());
    }

    @Override
    public void setup() {
        currwWord = new WorldGrass1(this);
        currwWord.initWorld();
    }

    @Override
    public void draw() {
        currwWord.updateWorld();
        if(currwWord.getControlablePlayers().isEmpty()){
            manageGameOver();
        }
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

    public void changeToNextWorld(){
        this.noLoop();
        switch (worldNumber) {
            case 2:
                currwWord = new WorldGrass2(this);
                currwWord.initWorld();
                break;
            case 3:
                currwWord = new WorldBrick1(this);
                currwWord.initWorld();
                break;
            case 4:
                currwWord = new WorldBrick2(this);
                currwWord.initWorld();
                break;
            case 5:
                manageGameOver();
                break;
        }
        worldNumber += 1;
        this.loop();
    }

    public void manageGameOver(){
        closeSketch();
        MainMenu mainmenu = new MainMenu();
        mainmenu.setBounds(GUIUtils.getBounds(844, 660));
        mainmenu.setVisible(true);
    }

    private void closeSketch(){
        noLoop();
        this.dispose();
        SmoothCanvas smoothCanvas = (SmoothCanvas)this.getSurface().getNative();
        JFrame frame = (JFrame) smoothCanvas.getFrame();
        frame.dispose();
    }

    @Override
    public void mouseClicked() {
        changeToNextWorld();
    }
}
