package plataformer.entities.alive;

import plataformer.entities.Hitbox;
import plataformer.entities.attacks.Arrow;
import plataformer.entities.attacks.ArrowAttack;
import plataformer.entities.attacks.ProyectileAttack;
import plataformer.entities.attacks.PunchAura;
import plataformer.entities.attacks.PunchAuraAttack;
import plataformer.map.GameSketch;

public class TestPlayer extends Player {

    private GameSketch gSketch;
    private char key;
    private boolean isKeyPressed;

    private int countPunch;
    private int countArrow;

    public TestPlayer(GameSketch gSketch, Hitbox hitbox, Stats stats) {
        super(hitbox, stats);
        this.gSketch = gSketch;

        hitbox.vx = stats.getVx();
        hitbox.vy = stats.getVy();

        this.key = '?';
        isKeyPressed = false;

        countPunch = 0;
        countArrow = 0;
    }

    @Override
    public void draw() {
        gSketch.fill(255);
        gSketch.rect(
            hitbox.l, hitbox.t, hitbox.w, hitbox.h
        );

        this.gSketch.textSize(12f);
        this.gSketch.fill(0, 0, 255);
        this.gSketch.text(
            "l:"+hitbox.l,
            hitbox.l, 
            hitbox.t - 40
        );
        this.gSketch.text(
            "r:"+hitbox.r,
            hitbox.l + 50, 
            hitbox.t - 40
        );
        this.gSketch.text(
            "t:"+hitbox.t,
            hitbox.l, 
            hitbox.t - 20
        );
        this.gSketch.text(
            "b:"+hitbox.b,
            hitbox.l + 50, 
            hitbox.t - 20
        );
        this.gSketch.text(
            "life:"+stats.getLife(),
            hitbox.l + 65, 
            hitbox.t - 60
        );
    }

    @Override
    public void update() {
        draw();

        if (isKeyPressed){
            if (key == 'd'){
                hitbox.moveRelative(hitbox.vx, 0);
            }
            if (key == 'a'){
                hitbox.moveRelative(-hitbox.vx, 0);
            }
            if (key == 'w'){
                hitbox.moveRelative(0, -hitbox.vy);
            }

            if (key == 'l' && countPunch == 0){
                Hitbox punchHitbox = new Hitbox(
                    (int)hitbox.l, (int)hitbox.t, 80, 50
                );
                PunchAura punchAura = new PunchAura(gSketch, punchHitbox);
                attackDisptacher.enqueAttack(new PunchAuraAttack(punchAura));
                attackDisptacher.enqueAttack(new PunchAuraAttack(punchAura));
                attackDisptacher.enqueAttack(new PunchAuraAttack(punchAura));
                countPunch = 180;
            }
            
            if(key == 'k' && countArrow == 0){
                Hitbox arrowHitbox = new Hitbox(
                    (int)hitbox.l, (int)hitbox.t, 30, 8
                );
                //in archer player, defined some attributte to know the direction;
                arrowHitbox.vx = 1.5f;
                //contrarestar la gravedad
                arrowHitbox.vy = -1.5f;
                Arrow arrow = new Arrow(gSketch, arrowHitbox);
                ProyectileAttack proyectileAttack = new ArrowAttack(arrow);
                attackDisptacher.sendCurrAttack(proyectileAttack);
                countArrow = 180;
            }
        }

        if(countPunch != 0){
            countPunch -= 1;
        }

        if(countArrow != 0){
            countArrow -= 1;
        }

    }

    @Override
    public void keyPressed(char key) {
        this.key = key;
        this.isKeyPressed = true;
    }

    @Override
    public void keyReleased() {
        this.isKeyPressed = false;
    }
    
}
