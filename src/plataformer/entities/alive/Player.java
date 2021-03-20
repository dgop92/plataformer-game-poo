package plataformer.entities.alive;

import plataformer.entities.Hitbox;

public abstract class Player extends AliveEntity implements ControlablePlayer{

    public Player(Hitbox hitbox, Stats stats) {
        super(hitbox, stats);
    }

}
