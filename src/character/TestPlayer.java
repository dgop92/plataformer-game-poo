package character;

import core.GameSketch;
import gamecomponents.Hitbox;

public class TestPlayer extends Player {

    private GameSketch gSketch;
    private char key;
    private boolean isKeyPressed;

    public TestPlayer(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
        this.key = '?';
        isKeyPressed = false;
    }

    @Override
    public void draw() {
        gSketch.fill(255);
        gSketch.rect(
            hitbox.l, hitbox.t, hitbox.w, hitbox.h
        );

        this.gSketch.textSize(12f);
        this.gSketch.fill(0, 0, 255);
        this.gSketch.text(
            "l:"+hitbox.l,
            hitbox.l, 
            hitbox.t - 40
        );
        this.gSketch.text(
            "r:"+hitbox.r,
            hitbox.l + 50, 
            hitbox.t - 40
        );
        this.gSketch.text(
            "t:"+hitbox.t,
            hitbox.l, 
            hitbox.t - 20
        );
        this.gSketch.text(
            "b:"+hitbox.b,
            hitbox.l + 50, 
            hitbox.t - 20
        );
    }

    @Override
    public void update() {
        draw();

        if (isKeyPressed){
            if (key == 'd'){
                hitbox.moveRelative(hitbox.vx, 0);
            }
            if (key == 'a'){
                hitbox.moveRelative(-hitbox.vx, 0);
            }
            if (key == 'w'){
                // System.out.println("w was pressed");
                hitbox.moveRelative(0, -hitbox.vy);
            }
    
            /* if(key == 'u'){
                hitbox.moveTo(50, 50);
            } */
            if(key == 'i'){
                hitbox.moveRelative(-1, 0);
            }
            if(key == 'o'){
                hitbox.moveRelative(1, 0);
            }
        }

    }

    @Override
    public void keyPressed(char key) {
        this.key = key;
        this.isKeyPressed = true;
    }

    @Override
    public void keyReleased() {
        this.isKeyPressed = false;
    }
    
}
