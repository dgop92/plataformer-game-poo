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

public class WorldGrass1 extends World{

    public WorldGrass1(GameSketch gSketch) {
        super(gSketch);
    }

    @Override
    protected void loadMap() {
        
        TileFactory tileFactory = new TileFactory(gSketch);
        
        JSONArray matrixMap = gSketch.loadJSONArray(
            "data/worldmaps/Worldgrass1.json"
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
        
        PImage grass;
        grass = this.gSketch.loadImage("data/worldsprite/grass.png");
        setWorldBgImage(grass);
        
    }

    @Override
    protected void createPlayers() {
        
        PlayerFactory playerFactory = new PlayerFactory(gSketch);
        Player testPlayer = playerFactory.createPlayer(
            PlayerType.TESTPLAYER, 
            new Point(300, 250)
        );
        
        entityManager.registerEntity(testPlayer);

    }

    @Override
    protected void createMounsters() {
        MounsterFactory mounsterFactory = new MounsterFactory(gSketch);
        Mounster testMounster = mounsterFactory.createMounster(
            MounsterType.TESTMOUNSTER, 
            new Point(450, 225)
        );
        Mounster testMounster2 = mounsterFactory.createMounster(
            MounsterType.TESTMOUNSTER, 
            new Point(550, 225)
        );
        Mounster testMounster3 = mounsterFactory.createMounster(
            MounsterType.TESTMOUNSTER, 
            new Point(195, 225)
        );
        entityManager.registerEntity(testMounster);
        entityManager.registerEntity(testMounster2);
        entityManager.registerEntity(testMounster3);
    }

    @Override
    protected void updateWorldHook() {
        gSketch.textSize(14f);
        this.gSketch.fill(255);
        this.gSketch.text("FrameRate:  "+gSketch.frameRate, 15, 15);
        
    }

    @Override
    protected EntityEffect[] getWorldEntityEffects() {
        EntityEffect[] ef = {new GravityEffect()};
        return ef;
    }
 
}
