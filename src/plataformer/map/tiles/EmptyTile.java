package plataformer.map.tiles;

import plataformer.entities.effects.EntityEffect;
import plataformer.map.GameSketch;

public class EmptyTile extends Tile{
    
    public EmptyTile(GameSketch gSketch, int x, int y, int tileSize) {
        super(gSketch, x, y, tileSize);
    }

    @Override
    public void draw() {
        
    }

    @Override
    public void update() {
        draw();
    }

    @Override
    public void loadImage(int dataValue) {

    }

    @Override
    public EntityEffect[] getEntityEffects() {
        return null;
    }
}
