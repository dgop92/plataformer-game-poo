package plataformer.map.worlds;

import java.awt.Point;
import java.util.HashMap;

import plataformer.entities.alive.Player;
import plataformer.entities.alive.PlayerFactory;
import plataformer.entities.alive.PlayerType;
import plataformer.entities.effects.EntityEffect;
import plataformer.entities.effects.GravityEffect;
import plataformer.map.GameSketch;
import plataformer.map.tiles.Tile;
import plataformer.map.tiles.TileFactory;
import processing.data.JSONArray;

public class TestWorld extends World{

    public TestWorld(GameSketch gSketch) {
        super(gSketch);
    }

    @Override
    protected void loadMap() {
        TileFactory tileFactory = new TileFactory(gSketch);
        
        JSONArray matrixMap = gSketch.loadJSONArray(
            "data/worldmaps/test-map16.json"
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
        
    }

    @Override
    protected EntityEffect[] getWorldEntityEffects() {
        EntityEffect[] ef = {new GravityEffect()};
        return ef;
    }
 
}
