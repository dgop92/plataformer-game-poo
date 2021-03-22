package plataformer.entities;

import java.util.ArrayList;

import plataformer.entities.alive.AliveEntity;
import plataformer.entities.alive.ControlablePlayer;
import plataformer.entities.effects.EntityEffect;

public class EntityManager {
    
    private ArrayList<Entity> entities;
    private ArrayList<AliveEntity> aliveEntities;
    private ArrayList<ControlablePlayer> controlablePlayers;
    
    private ArrayList<EntityEffect> entityEffects;

    public EntityManager() {
        entities = new ArrayList<>();
        aliveEntities = new ArrayList<>();
        controlablePlayers = new ArrayList<>();

        entityEffects = new ArrayList<>();
    }
    
    public void registerEntity(Entity entity){

        entities.add(entity);

        if (entity instanceof ControlablePlayer){
            controlablePlayers.add((ControlablePlayer)entity);
        }

        if (entity instanceof AliveEntity){
            aliveEntities.add((AliveEntity)entity);
        }
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
        
        for (Entity entity : entities) {
            entity.update();
            entityEffects.forEach(effect -> entity.applyEntityEffect(effect));
        }
    }
    
    public ArrayList<ControlablePlayer> getControlablePlayers() {
        return controlablePlayers;
    }
}
