package map;

import core.GameSketch;
import effects.CollideEffect;
import effects.HitBoxEffect;

public class GrassTile extends Tile {

    public GrassTile(GameSketch gSketch, int x, int y, int tileSize) {
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
            "t:"+tileContainer.ol,
            tileContainer.l, 
            tileContainer.t + 10
        );
        this.gSketch.text(
            "l:"+tileContainer.t,
            tileContainer.l, 
            tileContainer.t + 20
        );
        this.gSketch.text(
            "r:"+tileContainer.or,
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
    public HitBoxEffect[] getHitboxEffects() {
        HitBoxEffect[] he = {new CollideEffect(this.tileContainer)};
        return he;
    }
}
