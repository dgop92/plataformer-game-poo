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
            tileContainer.getX(), 
            tileContainer.getY(), 
            tileContainer.getWidth(), 
            tileContainer.getHeight()
        );

        this.gSketch.textSize(8f);
        this.gSketch.fill(0);
        this.gSketch.text(
            "x:"+tileContainer.getX(),
            tileContainer.getX(), 
            tileContainer.getY() + 10
        );
        this.gSketch.text(
            "y:"+tileContainer.getY(),
            tileContainer.getX(), 
            tileContainer.getY() + 20
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
