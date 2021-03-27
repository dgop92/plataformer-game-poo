package plataformer.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import plataformer.entities.alive.AliveEntity;
import plataformer.entities.attacks.Attack;
import plataformer.entities.attacks.ProyectileAttack;

public class AttackDisptacher {

    private Queue<Attack> attackQueue;
    private ArrayList<Entity> entities;
    private ArrayList<Attack> currAttacks;
    private Queue<Entity> entityQueue;

    public AttackDisptacher() {
        attackQueue = new LinkedList<>();
        currAttacks = new ArrayList<>();
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void setEntityQueue(Queue<Entity> entityQueue) {
        this.entityQueue = entityQueue;
    }

    public void enqueAttack(Attack attack) {
        attackQueue.offer(attack);
    }

    public void sendCurrAttack(Attack attack) {
        currAttacks.add(attack);

        if (attack instanceof ProyectileAttack){
            ProyectileAttack pAttack = (ProyectileAttack)attack;
            entityQueue.offer(pAttack.getProyectile());
        } 
    }

    public void processQueueAttacks() {

        while (!attackQueue.isEmpty()) {
            Attack attack = attackQueue.poll();
            for (Entity entity : entities) {
                if (entity instanceof AliveEntity) {
                    AliveEntity aliveEntity = (AliveEntity) entity;
                    aliveEntity.applyAttack(attack);
                }
            }
        }
    }

    public void processCurrentAttacks(){
        for (Entity entity : entities) {
            if (entity instanceof AliveEntity) {
                AliveEntity aliveEntity = (AliveEntity) entity;
                for (Attack attack : currAttacks) {
                    aliveEntity.applyAttack(attack);
                }
            }
        }
        
        currAttacks.removeIf(
            (attack) -> {
                if (attack instanceof ProyectileAttack){
                    ProyectileAttack pAttack = (ProyectileAttack)attack;
                    if (pAttack.getProyectile().isCollided()){
                        entities.remove(pAttack.getProyectile());
                        return true;
                    }
                }
                return false;
            }
        );
    }
}
