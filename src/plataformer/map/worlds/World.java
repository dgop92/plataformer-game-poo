package plataformer.map.worlds;

import java.util.ArrayList;
import java.util.HashMap;

import plataformer.entities.EntityManager;
import plataformer.entities.alive.ControlablePlayer;
import plataformer.entities.effects.EntityEffect;
import plataformer.entities.effects.NullEffect;
import plataformer.map.GameSketch;
import plataformer.map.tiles.Tile;

public abstract class World {
        
    protected EntityManager entityManager;
    protected GameSketch gSketch;
    protected Tile[][] tilemap;

    public World(GameSketch gSketch) {

        this.gSketch = gSketch;
        entityManager = new EntityManager();

    }

    public void initWorld(){

        loadMap();
        createPlayers();
        createMounsters();
        
        entityManager.addEntityEffects(getWorldEntityEffects());
    }

    public void updateWorld(){

        entityManager.updateEntities();

        for (Tile[] rowTiles : tilemap) {
            for (Tile tile : rowTiles) {
                tile.update();
            } 
        }

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

    protected EntityEffect[] getWorldEntityEffects(){
        EntityEffect[] ef = {new NullEffect()};
        return ef;
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
}
