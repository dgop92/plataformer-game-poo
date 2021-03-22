package plataformer.entities.alive;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;

public class TestMounster extends Mounster{
    
    private GameSketch gSketch;

    public TestMounster(GameSketch gSketch, Hitbox hitbox, Stats stats) {
        super(hitbox, stats);
        this.gSketch = gSketch;

        hitbox.vx = stats.getVx();
        hitbox.vy = stats.getVy();

    }

    @Override
    public void draw() {
        gSketch.fill(255, 0, 0);
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
        this.gSketch.text(
            "life:"+stats.getLife(),
            hitbox.l + 65, 
            hitbox.t - 60
        );
    }


    @Override
    public void update() {
        draw();
    }
}
