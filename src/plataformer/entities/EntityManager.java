package plataformer.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import plataformer.entities.alive.AliveEntity;
import plataformer.entities.alive.ControlablePlayer;
import plataformer.entities.effects.EntityEffect;

public class EntityManager {
    
    private ArrayList<Entity> entities;
    private ArrayList<EntityEffect> entityEffects;
    private Queue<Entity> entityQueue;
    
    private AttackDisptacher attackDisptacher;

    public EntityManager() {
        entities = new ArrayList<>();
        entityEffects = new ArrayList<>();
        entityQueue = new LinkedList<>();

        attackDisptacher = new AttackDisptacher();
        attackDisptacher.setEntities(entities);
        attackDisptacher.setEntityQueue(entityQueue);
    }
    
    public void registerEntity(Entity entity){

        entities.add(entity);

        if (entity instanceof AliveEntity){
            AliveEntity aliveEntity = (AliveEntity)entity;
            aliveEntity.setAttackDisptacher(attackDisptacher); 
        }
    }

    public void addEntity(Entity e){
        entityQueue.offer(e);
    }

    public void addEntityEffect(EntityEffect entityEffect){
        entityEffects.add(entityEffect);
    }

    public void addEntityEffects(EntityEffect[] entityEffects){
        for (EntityEffect entityEffect : entityEffects) {
            addEntityEffect(entityEffect);
        }
    }

    
    public void updateEntities(){

        while(!entityQueue.isEmpty()){
            entities.add(entityQueue.poll());
        }
        
        for (Entity entity : entities) {
            entity.update();
            entityEffects.forEach(effect -> entity.applyEntityEffect(effect));
        }

        entities.removeIf(
            (entity) -> {
                if (entity instanceof AliveEntity){
                    AliveEntity aEntity = (AliveEntity)entity;
                    return aEntity.getStats().getLife() <= 0;
                }
                return false;
            }
        );

        attackDisptacher.processQueueAttacks();
        attackDisptacher.processCurrentAttacks();
    }
    
    public ArrayList<ControlablePlayer> getControlablePlayers() {
       ArrayList<ControlablePlayer> cp = new ArrayList<>();
       for (Entity e : entities) {
           if (e instanceof ControlablePlayer){
               cp.add((ControlablePlayer)e);
           }
       }
       return cp;
    }

}
