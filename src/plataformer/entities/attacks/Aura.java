package plataformer.entities.attacks;

import plataformer.entities.Entity;
import plataformer.entities.Hitbox;

public abstract class Aura extends Entity{

    public Aura(Hitbox hitbox) {
        super(hitbox);
    }

    @Override
    public void update() {
        draw();
    }
    
}
