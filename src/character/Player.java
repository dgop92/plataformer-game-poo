package character;

import gamecomponents.Hitbox;

public abstract class Player extends Entity implements ControlablePlayer{

    public Player(Hitbox hitbox) {
        super(hitbox);
    }

}
