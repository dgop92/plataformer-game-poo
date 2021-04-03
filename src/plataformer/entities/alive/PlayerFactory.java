package plataformer.entities.alive;

import plataformer.entities.Hitbox;
import plataformer.map.GameSketch;
import java.awt.Point;

public class PlayerFactory {

    private GameSketch gSketch;

    public PlayerFactory(GameSketch gSketch) {
        this.gSketch = gSketch;
    }

    public Player createPlayer(PlayerType playerType, Point position) {

        Player player;
        switch (playerType) {
            case TESTPLAYER:

                Hitbox hitbox = new Hitbox(position.x, position.y, 20, 20);
                Stats stats = new PlayerStats(100, 5, 5);
                player = new TestPlayer(gSketch, hitbox, stats);

                break;
            case ARCHERPLAYER:

                Hitbox hitboxArcher = new Hitbox(position.x, position.y, 20, 45);
                Stats statsArcher = new PlayerStats(100, 2, 5);
                player = new ArcherPlayer(gSketch, hitboxArcher, statsArcher);

                break;
            default:
                player = null;

        }

        return player;

    }

}
