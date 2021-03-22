package plataformer.entities.alive;

import plataformer.entities.Entity;
import plataformer.entities.Hitbox;

public abstract class AliveEntity extends Entity{

    protected Stats stats;

    public AliveEntity(Hitbox hitbox, Stats stats) {
        super(hitbox);
        this.stats = stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }
    
}
