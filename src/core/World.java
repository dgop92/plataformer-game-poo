package core;

import java.util.ArrayList;

import character.ControlablePlayer;
import character.Entity;
import character.Player;
import character.TestPlayer;
import effects.GravityEffect;
import effects.HitBoxEffect;
import gamecomponents.Hitbox;
import map.Tile;
import map.TileFactory;
import processing.data.JSONArray;

public class World {
    
    private Tile[][] tilemap;
    private GameSketch gSketch;
    private ArrayList<HitBoxEffect> wordHitboxEffects; 
    private ArrayList<Entity> entities;
    private ArrayList<ControlablePlayer> controlablePlayers;
    private Player player;

    public World(GameSketch gSketch) {
        this.gSketch = gSketch;

        int rows = gSketch.getScreenSize().getNRows();
        int columns = gSketch.getScreenSize().getNColumns();

        player = new TestPlayer(gSketch, new Hitbox(300, 250, 20, 20));

        wordHitboxEffects = new ArrayList<>();
        entities = new ArrayList<>();
        controlablePlayers = new ArrayList<>();

        wordHitboxEffects.add(new GravityEffect());
        entities.add(player);
        controlablePlayers.add(player);

        tilemap = new Tile[rows][columns];
    }

    public void loadMap(String mapPath){
        JSONArray matrixMap = gSketch.loadJSONArray(mapPath);
        TileFactory tileFactory = new TileFactory(gSketch);
        JSONArray rowMap;

        int rows = gSketch.getScreenSize().getNRows();
        int columns = gSketch.getScreenSize().getNColumns();
        int tileSize = gSketch.getScreenSize().getTileSize();

        for (int i = 0; i < rows; i++) {
            rowMap = matrixMap.getJSONArray(i);
            for (int j = 0; j < columns; j++) {
                int[] dataInfo = parseMapItem(rowMap.getString(j));
                tilemap[i][j] = tileFactory.createTile(
                    j * tileSize, 
                    i * tileSize, 
                    dataInfo[0], 
                    tileSize
                );
                tilemap[i][j].loadImage(dataInfo[1]);
                /* if(tilemap[i][j].getHitboxEffects() != null){
                    System.out.println(tilemap[i][j]);
                } */
                addTileHitBoxEffects(tilemap[i][j].getHitboxEffects());
            }
        }
    }

    public void worldloop(){

        for (Tile[] rowTiles : tilemap) {
           for (Tile tile : rowTiles) {
               tile.update();
           } 
        }

        for (Entity entity : entities) {
            for (HitBoxEffect hitBoxEffect : wordHitboxEffects) {
                entity.applyHitboxEffect(hitBoxEffect);
            }
            entity.update();
        }
    }

    private int[] parseMapItem(String mapItem){
        int pointIndex = mapItem.indexOf('.');

        int dataId = Integer.parseInt(mapItem.substring(0, pointIndex));
        int dataValue = Integer.parseInt(
            mapItem.substring(pointIndex + 1, mapItem.length())
        );

        int[] dataInfo = {dataId, dataValue};
        return dataInfo;
    }

    private void addTileHitBoxEffects(HitBoxEffect[] hitBoxEffects){
        if (hitBoxEffects != null){
            for (HitBoxEffect hitBoxEffect : hitBoxEffects) {
                wordHitboxEffects.add(hitBoxEffect);
            }
        }
    }

    public ArrayList<ControlablePlayer> getControlablePlayers() {
        return controlablePlayers;
    }

}
