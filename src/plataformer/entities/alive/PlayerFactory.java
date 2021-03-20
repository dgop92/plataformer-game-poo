package plataformer.entities.alive;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;
import java.awt.Point;

public class PlayerFactory {
    
    public Player createPlayer(GameSketch gSketch, PlayerType playerType, 
        Point point) {
        Player player;
        switch (playerType) {
            case TESTPLAYER:
            
            Hitbox hitbox = new Hitbox(point.x, point.y, 50, 50);
            Stats stats = new PlayerStats(100, 10, 10);
            player = new TestPlayer(gSketch, hitbox, stats);

            break;

            default:
                player = null;

        }

        return player;
        
    }
}
