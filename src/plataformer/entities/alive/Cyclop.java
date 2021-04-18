package plataformer.entities.alive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;
import plataformer.map.worlds.TestWorld;
import processing.core.PImage;

/**
 *
 * @author andre
 */
public class Cyclop extends Mounster {
    private GameSketch gSketch;
    private boolean isCollidedl;
    float oldl;
    int i = -1;
    private PImage Img;
    private double cont = 1;
    private int count = 1;
    

    public Cyclop(GameSketch gSketch, Hitbox hitbox, Stats stats) {
        super(hitbox, stats);
        this.gSketch = gSketch;

        hitbox.vx = stats.getVx();
        hitbox.vy = stats.getVy();
        isCollidedl = false;
        oldl = hitbox.l;

    }

    @Override
    public void draw() {

        gSketch.image(Img,
                hitbox.l - 30, hitbox.t - 40, hitbox.w + 60, hitbox.h + 40
        );
        this.gSketch.textSize(12f);
        this.gSketch.fill(0, 0, 255);
        this.gSketch.text(
                "l:" + hitbox.l,
                hitbox.l,
                hitbox.t - 40
        );
        this.gSketch.text(
                "r:" + hitbox.r,
                hitbox.l + 50,
                hitbox.t - 40
        );
        this.gSketch.text(
                "t:" + hitbox.t,
                hitbox.l,
                hitbox.t - 20
        );
        this.gSketch.text(
                "b:" + hitbox.b,
                hitbox.l + 50,
                hitbox.t - 20
        );
        this.gSketch.text(
                "life:" + stats.getLife(),
                hitbox.l + 65,
                hitbox.t - 60
        );
    }

    @Override
    public void update() {
        execute(TestWorld.a);
        hitbox.moveRelative(i * hitbox.vx, 0);
        isCollidedl = oldl == hitbox.l;
        oldl = hitbox.l;
        if (isCollidedl) {
            i = i * -1;
        }
        if (i == 1) {
            Image("data\\mounster-sprites\\ciclopecaminarderecha.png", 12);
        } else {
            Image("data\\mounster-sprites\\ciclopecaminarizquierda.png", 12);
        }
        draw();
    }

    public void Image(String filePath, int max) {
        count = (int) cont;
        int index = filePath.indexOf(".");
        String imagePath = filePath.substring(0, index) + count + filePath.substring(index);
        Img = this.gSketch.loadImage(imagePath);
        cont += 0.1;
        if (cont > max - 0.09) {
            cont = 1;
        }
    }
    public void execute(AliveEntity aliveEntity) {

        Hitbox hitbox = aliveEntity.getHitbox();

        if (hitbox.b < this.hitbox.t || hitbox.t > this.hitbox.b || hitbox.l > this.hitbox.r
                || hitbox.r < this.hitbox.l) {
        } else {
           this.gSketch.stop();
        }
    }
}
