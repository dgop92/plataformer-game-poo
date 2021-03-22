package plataformer.entities.attacks;

import plataformer.entities.Entity;
import plataformer.entities.Hitbox;

public abstract class Proyectile extends Entity{

    public Proyectile(Hitbox hitbox) {
        super(hitbox);
    }    
}
