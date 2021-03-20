package plataformer.enitties;

import plataformer.enitties.effects.HitBoxEffect;
import plataformer.general.DrawableComponent;

public abstract class Entity implements DrawableComponent{
    
    protected Hitbox hitbox;

    public Entity(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public void applyHitboxEffect(HitBoxEffect hitBoxEffect) {
        hitBoxEffect.apply(hitbox);
    }
    
}
