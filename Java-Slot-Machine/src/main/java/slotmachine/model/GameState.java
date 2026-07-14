package slotmachine.model;

import java.io.Serializable;

public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Player player;
    private final Statistics statistics;

    public GameState(Player player,
                     Statistics statistics) {

        this.player = player;
        this.statistics = statistics;
    }

    public Player getPlayer() {
        return player;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}