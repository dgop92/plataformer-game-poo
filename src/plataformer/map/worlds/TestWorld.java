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
import processing.data.JSONArray;

public class TestWorld extends World {

    public static Player a;

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
                PlayerType.ARCHERPLAYER,
                new Point(300, 250)
        );
        a = testPlayer;
        entityManager.registerEntity(testPlayer);

    }

    @Override
    protected void createMounsters() {
        MounsterFactory mounsterFactory = new MounsterFactory(gSketch);
        Mounster testMounster = mounsterFactory.createMounster(
                MounsterType.CYCLOP,
                new Point(450, 400)
        );
        Mounster testMounster2 = mounsterFactory.createMounster(
                MounsterType.CYCLOP,
                new Point(550, 400)
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
    }

    @Override
    protected EntityEffect[] getWorldEntityEffects() {
        EntityEffect[] ef = {new GravityEffect()};
        return ef;
    }

}
