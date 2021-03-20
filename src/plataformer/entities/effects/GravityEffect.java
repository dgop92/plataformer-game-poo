package plataformer.entities.effects;

import plataformer.entities.Entity;

public class GravityEffect implements EntityEffect {

    @Override
    public void apply(Entity entity) {
        entity.getHitbox().moveRelative(0, 1.5f);
    }
    
}
