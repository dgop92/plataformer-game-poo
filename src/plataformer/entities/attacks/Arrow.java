package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;

public class Arrow extends Proyectile{

    private GameSketch gSketch;

    public Arrow(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
    }

    @Override
    public void draw() {
        gSketch.fill(0, 255, 0);
        gSketch.rect(
            hitbox.l, hitbox.t, hitbox.w, hitbox.h
        );
    }
    
}
