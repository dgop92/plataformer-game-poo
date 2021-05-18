package plataformer.map.tiles;

import plataformer.entities.effects.CollideEffect;
import plataformer.entities.effects.EntityEffect;
import plataformer.map.GameSketch;
import processing.core.PImage;

public class BrickTile extends Tile {
PImage brick;
    public BrickTile(GameSketch gSketch, int x, int y, int tileSize) {
        super(gSketch, x, y, tileSize);
    }

    @Override
    public void draw() {
        this.gSketch.fill(255);
        this.gSketch.image(
                brick,
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
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\1BRICK1.png");
                break;
            case 2: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\2BRICKAB.png");
                break;
            case 3: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\3BRICKAD.png");
                break;
            case 4: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\4BRICKABD.png");
                break;
            case 5: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\5BRICKABI.png");
                break;
            case 6: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\6BRICKD.png");
                break;
            case 7: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\7BRICKI.png");
                break;
            case 8: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\8BRICKCAD.png");
                break;
            case 9: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\9BRICKCAI.png");
                break;
            case 10: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\10BRICKCABD.png");
                break;
            case 11: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\11BRICKCABI.png");
                break;
            case 12: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\12BRICKAI.png");
                break;
            case 13: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\BRICKCOL.png");
                break;
            case 14: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\14BRICK1.png");
                break;
            case 15: 
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\ladrillo columna.png");
                break;     
            default:
                brick = this.gSketch.loadImage("data\\tiles\\BRICK\\BRICK.png");
             
            break;
        
        }
    }

    @Override
    public EntityEffect[] getEntityEffects() {
        EntityEffect[] ef = {new CollideEffect(this.tileContainer)};
        return ef;
    }
}
