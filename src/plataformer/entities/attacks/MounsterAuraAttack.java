package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.entities.alive.AliveEntity;
import plataformer.entities.alive.Player;

public class MounsterAuraAttack extends AuraAttack{

    private float damage;

    public MounsterAuraAttack(Aura aura, float damage) {
        super(aura);
        this.damage = damage;
    }
    
    @Override
    public void execute(AliveEntity aliveEntity) {

        Hitbox hitbox = aliveEntity.getHitbox();
        Hitbox auraContainer = aura.getHitbox();

        if (hitbox.b < auraContainer.t || hitbox.t > auraContainer.b || hitbox.l > auraContainer.r
                || hitbox.r < auraContainer.l) {

        }else{
            if (aliveEntity instanceof Player){
                aliveEntity.getStats().reduceLifeBy(damage);    
            }
        }

        aura.update();
    }
}
