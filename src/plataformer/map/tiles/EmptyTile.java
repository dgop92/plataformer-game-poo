package plataformer.map.tiles;

import plataformer.map.GameSketch;
import plataformer.enitties.effects.HitBoxEffect;

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
    public HitBoxEffect[] getHitboxEffects() {
        return null;
    }
}
