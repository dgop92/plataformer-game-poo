package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.entities.alive.AliveEntity;
import plataformer.entities.alive.Mounster;

public class PunchAuraAttack extends AuraAttack{

    public PunchAuraAttack(Aura aura) {
        super(aura);
        
    }

    @Override
    public void execute(AliveEntity aliveEntity) {

        Hitbox hitbox = aliveEntity.getHitbox();
        Hitbox auraContainer = aura.getHitbox();

        if (hitbox.b < auraContainer.t || hitbox.t > auraContainer.b || hitbox.l > auraContainer.r
                || hitbox.r < auraContainer.l) {

        }else{
            if (aliveEntity instanceof Mounster){
                aliveEntity.getStats().reduceLifeBy(25);    
            }
        }

        aura.update();
    }
    
}
