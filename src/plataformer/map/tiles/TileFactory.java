package plataformer.map.tiles;

import plataformer.map.GameSketch;

public class TileFactory {

    private GameSketch gSketch;

    public TileFactory(GameSketch gSketch) {
        this.gSketch = gSketch;
    }
    
    public Tile createTile(int x, int y, int dataId, int tileSize) {
        switch (dataId) {
            case 1:
                return new TestTile(gSketch, x, y, tileSize);
            default:
                return new EmptyTile(gSketch, x, y, tileSize);
        }
    }

}
