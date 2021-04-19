package plataformer.entities;

import plataformer.entities.effects.EntityEffect;
import plataformer.general.DrawableComponent;

public abstract class Entity implements DrawableComponent{

    protected Hitbox hitbox;

    public Entity(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public void applyEntityEffect(EntityEffect entityEffect) {
        entityEffect.apply(this);
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    }
