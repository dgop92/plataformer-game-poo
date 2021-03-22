package plataformer.entities.alive;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;
import java.awt.Point;

public class MounsterFactory {
    
    private GameSketch gSketch;

    public MounsterFactory(GameSketch gSketch) {
        this.gSketch = gSketch;
    }
    
    public Mounster createMounster(MounsterType mounsterType, Point position) {
        
        Mounster mounster;
        switch (mounsterType) {
            case TESTMOUNSTER:
            
            Hitbox hitbox = new Hitbox(position.x, position.y, 30, 30);
            Stats stats = new PlayerStats(200, 5, 5);
            mounster = new TestMounster(gSketch, hitbox, stats);

            break;

            default:
                mounster = null;

        }

        return mounster;
        
    }
}
