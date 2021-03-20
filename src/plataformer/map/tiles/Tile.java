package plataformer.map.tiles;

import plataformer.map.GameSketch;
import plataformer.enitties.effects.HitBoxEffect;
import plataformer.general.DrawableComponent;
import plataformer.enitties.Hitbox;
import processing.core.PImage;

public abstract class Tile implements DrawableComponent{
    
    protected PImage tileImage;
    protected Hitbox tileContainer;
    protected GameSketch gSketch;

    public Tile(GameSketch gSketch, int x, int y, int tileSize) {
        this.gSketch = gSketch;
        tileContainer = new Hitbox(x, y, tileSize, tileSize);
    }

    public abstract void loadImage(int dataValue);

    public abstract HitBoxEffect[] getHitboxEffects();

    @Override
    public String toString() {
        return String.format(
            "Tile with pos %s %s", 
            tileContainer.l, 
            tileContainer.t
        );
    }
}
