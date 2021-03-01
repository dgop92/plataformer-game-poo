package character;

import core.GameSketch;
import gamecomponents.Hitbox;

public class TestPlayer extends Player {

    private GameSketch gSketch;

    public TestPlayer(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
    }

    @Override
    public void draw() {
        gSketch.fill(255);
        gSketch.rect(
            hitbox.getX(), hitbox.getY(), hitbox.getWidth(), hitbox.getHeight()
        );

        this.gSketch.textSize(12f);
        this.gSketch.fill(0, 0, 255);
        this.gSketch.text(
            "x:"+hitbox.getX(),
            hitbox.getX(), 
            hitbox.getY() - 40
        );
        this.gSketch.text(
            "xm:"+hitbox.getRectContainer().getMaxX(),
            hitbox.getX() + 50, 
            hitbox.getY() - 40
        );
        this.gSketch.text(
            "y:"+hitbox.getY(),
            hitbox.getX(), 
            hitbox.getY() - 20
        );
    }

    @Override
    public void update() {
        draw();
    }

    @Override
    public void keyPressed(char key) {
        if (key == 'd'){
            hitbox.moveRelative(5, 0);
        }
        if (key == 'a'){
            hitbox.moveRelative(-5, 0);
        }
        if (key == 'w'){
            hitbox.moveRelative(0, -50);
        }

        if(key == 'u'){
            hitbox.moveTo(50, 50);
        }
        if(key == 'i'){
            hitbox.moveRelative(-1, 0);
        }
        if(key == 'o'){
            hitbox.moveRelative(1, 0);
        }
    }

    @Override
    public void keyReleased() {

    }
    
}
