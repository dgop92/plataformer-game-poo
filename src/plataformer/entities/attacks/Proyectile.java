package plataformer.entities.attacks;

import plataformer.entities.Entity;
import plataformer.entities.Hitbox;

public abstract class Proyectile extends Entity{

    private boolean collided;
    float oldl;

    public Proyectile(Hitbox hitbox) {
        super(hitbox);
        collided = false;
        oldl = hitbox.l;
    }

    public boolean isCollided() {
        return collided;
    }

    @Override
    public void update() {
        if(oldl != hitbox.l){
            collided = true;
        }
        hitbox.moveRelative();
        oldl = hitbox.l; 
        draw();
    }

}
