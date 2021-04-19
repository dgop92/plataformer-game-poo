package plataformer.map.tiles;

import plataformer.entities.effects.CollideEffect;
import plataformer.entities.effects.EntityEffect;
import plataformer.map.GameSketch;
import processing.core.PImage;

public class GrassTile extends Tile {
PImage grass1;
    public GrassTile(GameSketch gSketch, int x, int y, int tileSize) {
        super(gSketch, x, y, tileSize);
    }

    @Override
    public void draw() {
        this.gSketch.fill(255);
        this.gSketch.image(
                grass1,
            tileContainer.l, 
            tileContainer.t, 
            tileContainer.w, 
            tileContainer.h
        );

    }

    @Override
    public void update() {
        draw();
    }

    @Override
    public void loadImage(int dataValue) {
        switch (dataValue){
            case 1: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS.png");
                break;
            case 2: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS2.png");
                break;
            case 3: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS3.png");
                break;
            case 4: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS4.png");
                break;
            case 5: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS5.png");
                break;
            case 6: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS6.png");
                break;
            case 7: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS7.png");
                break;
            case 8: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS8.png");
                break;
            case 9: 
                grass1 = this.gSketch.loadImage("data\\tiles\\DIRT.png");
                break;
            case 10: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS10.png");
                break;
            case 11: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS11.png");
                break;
            case 12: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS12.png");
                break;
            case 13: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS13.png");
                break;
            case 14: 
                grass1 = this.gSketch.loadImage("data\\tiles\\GRASS14.png");
                break;     
            default:
                grass1 = this.gSketch.loadImage("data\\tiles\\DIRT.png");
             
            break;
        
        }
    }

    @Override
    public EntityEffect[] getEntityEffects() {
        EntityEffect[] ef = {new CollideEffect(this.tileContainer)};
        return ef;
    }
}
