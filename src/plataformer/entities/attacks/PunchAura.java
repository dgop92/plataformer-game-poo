package plataformer.entities.attacks;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;
import processing.core.PImage;

public class PunchAura extends Aura {

    private GameSketch gSketch;
    private int direccion;
    private PImage Img;

    public PunchAura(GameSketch gSketch, Hitbox hitbox) {
        super(hitbox);
        this.gSketch = gSketch;
        Img = this.gSketch.loadImage("data\\attack-effect-sprites\\aura5.png");
        direccion = 1;
    }

    @Override
    public void draw() {
        gSketch.fill(255);
        if (direccion == 1) {
            gSketch.image(Img,
                    hitbox.l-25 , hitbox.t-50, hitbox.w + 50, hitbox.h + 150);
        } else {
            gSketch.image(Img,
                    hitbox.l+40 , hitbox.t-50 , hitbox.w-50 , hitbox.h + 150);
        }
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

}
