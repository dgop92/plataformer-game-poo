package plataformer.map.tiles;

import plataformer.entities.effects.CollideEffect;
import plataformer.entities.effects.EntityEffect;
import plataformer.map.GameSketch;

public class TestTile extends Tile {

    public TestTile(GameSketch gSketch, int x, int y, int tileSize) {
        super(gSketch, x, y, tileSize);
    }

    @Override
    public void draw() {
        this.gSketch.fill(255);
        this.gSketch.rect(
            tileContainer.l, 
            tileContainer.t, 
            tileContainer.w, 
            tileContainer.h
        );

        this.gSketch.textSize(8f);
        this.gSketch.fill(0);
        this.gSketch.text(
            "t:"+tileContainer.l,
            tileContainer.l, 
            tileContainer.t + 10
        );
        this.gSketch.text(
            "l:"+tileContainer.t,
            tileContainer.l, 
            tileContainer.t + 20
        );
        this.gSketch.text(
            "r:"+tileContainer.r,
            tileContainer.l, 
            tileContainer.t + 30
        );
        this.gSketch.text(
            "b:"+tileContainer.b,
            tileContainer.l, 
            tileContainer.t + 40
        );
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
        EntityEffect[] he = {new CollideEffect(this.tileContainer)};
        return he;
    }
}
