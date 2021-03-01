package character;

import effects.HitBoxEffect;
import gamecomponents.DrawableComponent;
import gamecomponents.Hitbox;

public abstract class Entity implements DrawableComponent{
    
    protected Hitbox hitbox;

    public Entity(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public void applyHitboxEffect(HitBoxEffect hitBoxEffect) {
        hitBoxEffect.apply(hitbox);
    }
    
}
