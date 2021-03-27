package plataformer.entities.alive;

import plataformer.entities.AttackDisptacher;
import plataformer.entities.Entity;
import plataformer.entities.Hitbox;
import plataformer.entities.attacks.Attack;

public abstract class AliveEntity extends Entity{

    protected Stats stats;
    protected AttackDisptacher attackDisptacher;

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

    public void setAttackDisptacher(AttackDisptacher attackDisptacher) {
        this.attackDisptacher = attackDisptacher;
    }

    public AttackDisptacher getAttackDisptacher() {
        return attackDisptacher;
    }

    public void applyAttack(Attack attack){
        attack.execute(this);
    }
    
}
