package effects;

import gamecomponents.Hitbox;
import java.awt.Rectangle;

public class CollideEffect implements HitBoxEffect {

    private Hitbox tileContainer;

    public CollideEffect(Hitbox tileContainer) {
        this.tileContainer = tileContainer;
    }

    @Override
    public void apply(Hitbox hitbox) {
        int collisionTol = 3;

        Rectangle entityRect = hitbox.getRectContainer();
        Rectangle tileRect = tileContainer.getRectContainer();

        if (entityRect.intersects(tileRect)) {

            if (Math.abs(entityRect.getMaxY() - tileRect.y) < collisionTol) {
                //hitbox.moveTo(hitbox.getX(), (float)entityRect.y - 1);
                hitbox.moveRelative(0, -1.5f);
            }

            if (Math.abs(tileRect.getMaxY() - entityRect.y) < collisionTol) {
                System.out.println("up");
                hitbox.moveRelative(0, 1f);
            }

            if (Math.abs(entityRect.getMaxX() - tileRect.x) < collisionTol) {
                System.out.println("tile right, ent left");
                // hitbox.moveTo((float)entityRect.x - 3, hitbox.getY());
                //hitbox.moveRelative(-5f, 0);
            }

            if (Math.abs(tileRect.getMaxX() - entityRect.x) < collisionTol) {
                System.out.println("tile left, ent right");
                // hitbox.moveTo((float)entityRect.x + 3, hitbox.getY());
                //hitbox.moveRelative(4, 0);
                //hitbox.moveRelative(-5f, 0);
            }

        }
    }

}
