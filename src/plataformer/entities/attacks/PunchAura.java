package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;

public class PunchAura extends Aura{

    private GameSketch gSketch;

    public PunchAura(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
    }

    @Override
    public void draw() {
        gSketch.fill(255, 255, 0);
        gSketch.rect(
            hitbox.l, hitbox.t, hitbox.w, hitbox.h
        );
    }
    
}
