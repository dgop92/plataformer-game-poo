package plataformer.entities.alive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import plataformer.entities.Hitbox;
import plataformer.entities.attacks.Arrow;
import plataformer.entities.attacks.ArrowAttack;
import plataformer.entities.attacks.ProyectileAttack;
import plataformer.entities.attacks.PunchAura;
import plataformer.entities.attacks.PunchAuraAttack;
import plataformer.map.GameSketch;
import processing.core.PImage;

/**
 *
 * @author andre
 */
public class ArcherPlayer extends Player {

    private GameSketch gSketch;
    private char key;
    private boolean isKeyPressed;
    private int countPunch;
    private int countArrow;
    private PImage Img;
    private double cont = 1;
    private int count = 1;
    private boolean collided;
    private boolean isCollided;
    float oldl;
    int direccion = 1;

    public ArcherPlayer(GameSketch gSketch, Hitbox hitbox, Stats stats) {
        super(hitbox, stats);
        this.gSketch = gSketch;

        hitbox.vx = stats.getVx();
        hitbox.vy = stats.getVy();

        this.key = '?';
        isKeyPressed = false;

        countPunch = 0;
        countArrow = 0;
        collided = false;
        isCollided = false;
        oldl = hitbox.t;
    }

    @Override

    public void draw() {
        gSketch.fill(255);

        gSketch.image(Img,
                hitbox.l - 17, hitbox.t - 10, hitbox.w + 35, hitbox.h + 10);

    }

    @Override
    public void update() {
        isCollided = oldl == hitbox.t;
        oldl = hitbox.t;
        if (isCollided == false) {
            if (direccion == 1) {
                Img = this.gSketch.loadImage("data\\players-sprites\\arquerojumping6.png");
            } else {
                Img = this.gSketch.loadImage("data\\players-sprites\\arquerojumpingleft6.png");
            }
        } else {
            if (direccion == 1) {
                Img = this.gSketch.loadImage("data\\players-sprites\\arquero.png");
            } else {
                Img = this.gSketch.loadImage("data\\players-sprites\\arqueroleft.png");
            }

        }
        if (key == 'k'||key=='l') {
            if (direccion == 1) {
                Image("data\\players-sprites\\disparararquero.png", 9);
            }
            if (direccion == -1) {
                Image("data\\players-sprites\\disparararqueroleft.png", 9);
            }
        }

        if (isKeyPressed) {
            if (key == 'd') {
                hitbox.moveRelative(hitbox.vx, 0);
                Image("data\\players-sprites\\arquerorunning.png", 8);
                direccion = 1;
            }
            if (key == 'a') {
                hitbox.moveRelative(-hitbox.vx, 0);
                Image("data\\players-sprites\\arquerorunningleft.png", 8);
                direccion = -1;
            }
            if (key == 'e') {
                direccion = 1;
                if (collided) {
                    hitbox.moveRelative(hitbox.vx, -hitbox.vy);
                    Image("data\\players-sprites\\arquerojumping.png", 7);
                }
            }
            if (key == 'q') {
                direccion = -1;
                if (collided) {
                    hitbox.moveRelative(-hitbox.vx, -hitbox.vy);
                    Image("data\\players-sprites\\arquerojumpingleft.png", 7);
                }
            }
            if (key == 'w') {

                if (collided) {
                    if (direccion == 1) {
                        Image("data\\players-sprites\\arquerojumping.png", 7);
                    } else {
                        Image("data\\players-sprites\\arquerojumpingleft.png", 7);
                    }

                    hitbox.moveRelative(0, -5);
                }
            }
            if (key == 'l' && countPunch == 0) {
                Hitbox punchHitbox;
                if (direccion==1) {
                      punchHitbox = new Hitbox(
                        (int) hitbox.r, (int) hitbox.t, 80, 50
                );
                }else{
                      punchHitbox = new Hitbox(
                        (int) hitbox.l, (int) hitbox.t, -80, 50
                );
                      
                }
               
                            
                PunchAura punchAura = new PunchAura(gSketch, punchHitbox);
                punchAura.setDireccion(direccion);
                attackDisptacher.enqueAttack(new PunchAuraAttack(punchAura));
                attackDisptacher.enqueAttack(new PunchAuraAttack(punchAura));
                attackDisptacher.enqueAttack(new PunchAuraAttack(punchAura));
                countPunch = 180;
            }
            if (key == 'k' && countArrow == 0) {

                Hitbox arrowHitbox = new Hitbox(
                        (int) hitbox.l, (int) hitbox.t + 20, 30, 8
                );
                //in archer player, defined some attributte to know the direction;
                arrowHitbox.vx = 1.5f * direccion;
                //contrarestar la gravedad
                arrowHitbox.vy = -1.5f;
                Arrow arrow = new Arrow(gSketch, arrowHitbox);
                ProyectileAttack proyectileAttack = new ArrowAttack(arrow);
                arrow.setDireccion(direccion);
                attackDisptacher.sendCurrAttack(proyectileAttack);
                countArrow = 180;
            }
        }
        draw();
        if (countPunch
                != 0) {
            countPunch -= 1;
        }
        if (countArrow
                != 0) {
            countArrow -= 1;
        }
    }

    @Override
    public void keyPressed(char key) {
        this.key = key;
        this.isKeyPressed = true;
        collided = oldl == hitbox.t;

    }

    @Override
    public void keyReleased() {
        this.isKeyPressed = false;

    }

    public void Image(String filePath, int max) {
        if (cont > max - 0.09) {
            cont = 1;
        }
        count = (int) cont;
        int index = filePath.indexOf(".");
        String imagePath = filePath.substring(0, index) + count + filePath.substring(index);
        Img = this.gSketch.loadImage(imagePath);
        cont += 0.1;

    }
    
}
