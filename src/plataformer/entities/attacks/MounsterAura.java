package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;

public class MounsterAura extends Aura{

    private GameSketch gSketch;

    public MounsterAura(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
    }

    @Override
    public void draw() {
        
    }
    
}
