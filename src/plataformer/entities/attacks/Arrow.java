package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;
import processing.core.PImage;

public class Arrow extends Proyectile {

    private GameSketch gSketch;
    private PImage Img;
    private int direccion;

    public Arrow(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
        Img = this.gSketch.loadImage("data\\attack-effect-sprites\\flecha.png");
    }

    @Override
    public void draw() {
        if (direccion == 1) {
            gSketch.image(Img,
                    hitbox.l - 15, hitbox.t - 15, hitbox.w + 30, hitbox.h + 30);
        } else {
            Img = this.gSketch.loadImage("data\\attack-effect-sprites\\flechal.png");
            gSketch.image(Img,
                    hitbox.l - 15, hitbox.t - 15, hitbox.w + 30, hitbox.h + 30);
        }
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

}
