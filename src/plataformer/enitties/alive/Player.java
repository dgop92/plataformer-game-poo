package plataformer.enitties.alive;

import plataformer.enitties.Entity;
import plataformer.enitties.Hitbox;

public abstract class Player extends Entity implements ControlablePlayer{

    public Player(Hitbox hitbox) {
        super(hitbox);
    }

}
