package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.entities.alive.AliveEntity;
import plataformer.entities.alive.Mounster;

public class ArrowAttack extends ProyectileAttack{

    public ArrowAttack(Proyectile proyectile) {
        super(proyectile);
    }

    @Override
    public void execute(AliveEntity aliveEntity) {

        Hitbox hitbox = aliveEntity.getHitbox();
        Hitbox proyectileContainer = proyectile.getHitbox();

        if (hitbox.b < proyectileContainer.t || hitbox.t > proyectileContainer.b || hitbox.l > proyectileContainer.r
                || hitbox.r < proyectileContainer.l) {

        }else{
            if (aliveEntity instanceof Mounster){
                aliveEntity.getStats().reduceLifeBy(5);    
            }
        }
    }

    @Override
    public Proyectile getProyectile(){
        return proyectile;
    }
    
}
