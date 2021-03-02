package effects;

import gamecomponents.Hitbox;

public class CollideEffect implements HitBoxEffect {

    private Hitbox tileContainer;

    public CollideEffect(Hitbox tileContainer) {
        this.tileContainer = tileContainer;
    }

    @Override
    public void apply(Hitbox hitbox) {

        if (hitbox.b < tileContainer.t || hitbox.t > tileContainer.b || hitbox.l > tileContainer.r
                || hitbox.r < tileContainer.l) {

        } else {

            /* if (hitbox.r >= tileContainer.l && hitbox.or < tileContainer.ol) {

                hitbox.setRight(tileContainer.l - 0.1f);
                hitbox.vx = tileContainer.vx;
                System.out.println("que pasa");
            }
            
            if (hitbox.l <= tileContainer.r && hitbox.ol > tileContainer.or) {

                hitbox.setLeft(tileContainer.r + 0.1f);
                hitbox.vx = tileContainer.vx;
                System.out.println("que pasa2");

            }

            if (hitbox.b >= tileContainer.t && hitbox.ob < tileContainer.ot) {

                hitbox.setBottom(tileContainer.t - 0.1f);
                //hitbox.vy = tileContainer.vy; // the platform moves the player with it after collision...
                // hitbox.jumping = false;

            }
            
            if (hitbox.t <= tileContainer.b && hitbox.ot > tileContainer.ob) {

                hitbox.setTop(tileContainer.b + 0.1f);
                //hitbox.vy = tileContainer.vy; // ... regardless of what side the player collides with

            } */
            float collisionTol = 5;
            if (Math.abs(hitbox.b - tileContainer.t) < collisionTol) {
                hitbox.setBottom(tileContainer.t - 0.1f);
            }else if (Math.abs(tileContainer.b - hitbox.t) < collisionTol) {
                hitbox.setTop(tileContainer.b + 0.1f);
            }else if (Math.abs(hitbox.r - tileContainer.l) < collisionTol) {
                hitbox.setRight(tileContainer.l - 0.1f);
            }else if (Math.abs(tileContainer.r - hitbox.l) < collisionTol) {
                hitbox.setLeft(tileContainer.r + 0.1f);
            }
            
        

        }

    }

}
