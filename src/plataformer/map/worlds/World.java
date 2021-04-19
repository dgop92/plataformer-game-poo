package plataformer.map.worlds;

import java.util.ArrayList;
import java.util.HashMap;

import plataformer.entities.EntityManager;
import plataformer.entities.Hitbox;
import plataformer.entities.alive.ControlablePlayer;
import plataformer.entities.alive.Player;
import plataformer.entities.effects.CollideEffect;
import plataformer.entities.effects.EntityEffect;
import plataformer.entities.effects.NullEffect;
import plataformer.map.GameSketch;
import plataformer.map.tiles.Tile;
import processing.core.PImage;
import java.awt.Point;

public abstract class World {
        
    protected EntityManager entityManager;
    protected GameSketch gSketch;
    protected Tile[][] tilemap;
    
    protected PImage worldBgImage;
    protected Point nextWorldPoint;
    protected Player worldPlayer;

    public World(GameSketch gSketch) {

        this.gSketch = gSketch;
        entityManager = new EntityManager();

    }

    public void initWorld(){

        loadMap();
        createPlayers();
        createMounsters();
        
        entityManager.addEntityEffects(getWorldEffects());
    }

    public void updateWorld(){
       
        this.gSketch.background(worldBgImage);

        entityManager.updateEntities();

        for (Tile[] rowTiles : tilemap) {
            for (Tile tile : rowTiles) {
                tile.update();
            } 
        }

        boolean isInside = checkIfPlayerIsInNextWorldPoint();
        if(isInside){
            gSketch.changeToNextWorld();
        }
        gSketch.text(
            "next",
            (float)nextWorldPoint.getX(), 
            (float)nextWorldPoint.getY()
        );

        updateWorldHook();
    }

    protected void updateWorldHook(){

    }

    public ArrayList<ControlablePlayer> getControlablePlayers(){
        return entityManager.getControlablePlayers();
    }

    protected abstract void loadMap();

    protected abstract void createPlayers();

    protected abstract void createMounsters();

    protected void setWorldBgImage(PImage worldBgImage) {
        this.worldBgImage = worldBgImage;
    }

    protected void setNextWorldPoint(Point nextWorldPoint) {
        this.nextWorldPoint = nextWorldPoint;
    }

    public void setWorldPlayer(Player worldPlayer) {
        this.worldPlayer = worldPlayer;
    }

    protected EntityEffect[] getWorldEntityEffects(){
        EntityEffect[] ef = {new NullEffect()};
        return ef;
    }

    private EntityEffect[] getWorldEffects(){
        EntityEffect[] we = getWorldEntityEffects();

        int screenWidth = gSketch.getScreenSize().getWidth();
        int screenHeight = gSketch.getScreenSize().getHeight();
        EntityEffect[] dwe = new EntityEffect[]{
            new CollideEffect(new Hitbox(-4, 0, 5, screenHeight)),
            new CollideEffect(new Hitbox(screenWidth, 0, 5, screenHeight))
        };

        EntityEffect[] entityEffects = new EntityEffect[we.length + dwe.length];

        System.arraycopy(we, 0, entityEffects, 0, we.length);
        System.arraycopy(dwe, 0, entityEffects, we.length, dwe.length);
        
        return entityEffects;
    }

    protected HashMap<String, Integer> getMapitemData(String mapItem){

        HashMap<String, Integer> mapItemData = new HashMap<>();
        int pointIndex = mapItem.indexOf('.');

        int dataId = Integer.parseInt(mapItem.substring(0, pointIndex));
        int dataValue = Integer.parseInt(
            mapItem.substring(pointIndex + 1, mapItem.length())
        );

        mapItemData.put("dataId", dataId);
        mapItemData.put("dataValue", dataValue);

        return mapItemData;
    }

    private boolean checkIfPlayerIsInNextWorldPoint(){
        Hitbox hitbox = worldPlayer.getHitbox();
        boolean isInside = nextWorldPoint.x > hitbox.l 
            && nextWorldPoint.x < hitbox.r && nextWorldPoint.y > hitbox.t
            && nextWorldPoint.y < hitbox.b;
        return isInside; 
    }
}
