package plataformer.map.worlds;

import java.awt.Point;
import java.util.HashMap;

import plataformer.entities.alive.Mounster;
import plataformer.entities.alive.MounsterFactory;
import plataformer.entities.alive.MounsterType;
import plataformer.entities.alive.Player;
import plataformer.entities.alive.PlayerFactory;
import plataformer.entities.alive.PlayerType;
import plataformer.entities.effects.EntityEffect;
import plataformer.entities.effects.GravityEffect;
import plataformer.map.GameSketch;
import plataformer.map.tiles.Tile;
import plataformer.map.tiles.TileFactory;
import processing.core.PImage;
import processing.data.JSONArray;

public class WorldBrick2 extends World{

    public WorldBrick2(GameSketch gSketch) {
        super(gSketch);
    }

    @Override
    protected void loadMap() {
        
        TileFactory tileFactory = new TileFactory(gSketch);
        
        JSONArray matrixMap = gSketch.loadJSONArray(
            "data/worldmaps/Worldbrick2.json"
        );
        JSONArray rowMap;
        
        int rows = gSketch.getScreenSize().getNRows();
        int columns = gSketch.getScreenSize().getNColumns();
        int tileSize = gSketch.getScreenSize().getTileSize();
        
        tilemap = new Tile[rows][columns];

        for (int i = 0; i < rows; i++) {
            rowMap = matrixMap.getJSONArray(i);
            for (int j = 0; j < columns; j++) {

                HashMap<String, Integer> mapItemData = getMapitemData(
                    rowMap.getString(j)
                );

                Tile tile = tileFactory.createTile(
                    j * tileSize, 
                    i * tileSize, 
                    mapItemData.get("dataId"), 
                    tileSize
                );
                tile.loadImage(mapItemData.get("dataValue"));

                entityManager.addEntityEffects(tile.getEntityEffects());

                tilemap[i][j] = tile;
            }
        }
        
        PImage brick;
        brick = this.gSketch.loadImage("data/worldsprite/brick.png");
        setWorldBgImage(brick);
        setNextWorldPoint(new Point(730, 450));
    }

    @Override
    protected void createPlayers() {
        
        PlayerFactory playerFactory = new PlayerFactory(gSketch);
        Player archPlayer = playerFactory.createPlayer(
            PlayerType.ARCHERPLAYER, 
            new Point(20, 550)
        );
        
        entityManager.registerEntity(archPlayer);
        setWorldPlayer(archPlayer);

    }

    @Override
    protected void createMounsters() {
        
        MounsterFactory mounsterFactory = new MounsterFactory(gSketch);
        
        Point[] points = new Point[]{
            new Point(200, 250),
            new Point(300, 250),
            new Point(400, 250),
            new Point(550, 250),
            new Point(750, 150)
        };

        for (Point point : points) {
            Mounster c = mounsterFactory.createMounster(
                MounsterType.CYCLOP,
                point
            );
            entityManager.registerEntity(c);   
        }
    }

    @Override
    protected void updateWorldHook() {
        gSketch.textSize(14f);
        this.gSketch.fill(255);
    }

    @Override
    protected EntityEffect[] getWorldEntityEffects() {
        EntityEffect[] ef = {new GravityEffect()};
        return ef;
    } 
 
}
