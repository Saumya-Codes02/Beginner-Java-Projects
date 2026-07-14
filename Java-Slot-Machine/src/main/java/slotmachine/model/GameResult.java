package slotmachine.model;

import java.io.Serializable;
import java.util.Arrays;

public class GameResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Symbol[] row;
    private final int bet;
    private final int payout;
    private final boolean win;
    private final boolean jackpot;

    public GameResult(Symbol[] row,
                      int bet,
                      int payout,
                      boolean jackpot) {

        this.row = Arrays.copyOf(row, row.length);
        this.bet = bet;
        this.payout = payout;
        this.win = payout > 0;
        this.jackpot = jackpot;
    }

    public Symbol[] getRow() {
        return Arrays.copyOf(row, row.length);
    }

    public int getBet() {
        return bet;
    }

    public int getPayout() {
        return payout;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isJackpot() {
        return jackpot;
    }

    @Override
    public String toString() {

        return "GameResult{" +
                "row=" + Arrays.toString(row) +
                ", bet=" + bet +
                ", payout=" + payout +
                ", jackpot=" + jackpot +
                '}';
    }
}