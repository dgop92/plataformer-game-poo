package plataformer.entities.alive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import plataformer.entities.Hitbox;
import plataformer.entities.attacks.MounsterAura;
import plataformer.entities.attacks.MounsterAuraAttack;
import plataformer.map.GameSketch;
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
    private MounsterAuraAttack mounsterAuraAttack;
    private int mounsterAuraCount;

    public Cyclop(GameSketch gSketch, Hitbox hitbox, Stats stats) {
        super(hitbox, stats);
        this.gSketch = gSketch;

        hitbox.vx = stats.getVx();
        hitbox.vy = stats.getVy();
        isCollidedl = false;
        oldl = hitbox.l;
        MounsterAura mounsterAura = new MounsterAura(gSketch, this.hitbox);
        mounsterAuraAttack = new MounsterAuraAttack(mounsterAura, 10);
        mounsterAuraCount = 0;
    }

    @Override
    public void draw() {

        gSketch.image(Img,
                hitbox.l - 30, hitbox.t - 40, hitbox.w + 60, hitbox.h + 40
        );
    }

    @Override
    public void update() {
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
        if(mounsterAuraCount == 0){
            attackDisptacher.enqueAttack(mounsterAuraAttack);
            mounsterAuraCount = 10;
        }
        draw();
        if (mounsterAuraCount != 0) {
            mounsterAuraCount -= 1;
        }
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
}
