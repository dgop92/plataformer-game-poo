package plataformer.entities.attacks;

import plataformer.entities.alive.AliveEntity;

public interface Attack {
    
    public void execute(AliveEntity aliveEntity);
}
