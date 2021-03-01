package effects;

import gamecomponents.Hitbox;

public class GravityEffect implements HitBoxEffect {

    @Override
    public void apply(Hitbox hitbox) {
        hitbox.moveRelative(0, 1.5f);
    }
    
}
