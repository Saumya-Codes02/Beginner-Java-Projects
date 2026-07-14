package slotmachine.model;

import java.io.Serializable;

public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;

    private int gamesPlayed;
    private int wins;
    private int losses;

    private int totalBet;
    private int totalWon;

    private int highestWin;

    public void recordWin(int bet, int payout) {

        gamesPlayed++;
        wins++;

        totalBet += bet;
        totalWon += payout;

        if (payout > highestWin) {
            highestWin = payout;
        }
    }

    public void recordLoss(int bet) {

        gamesPlayed++;
        losses++;

        totalBet += bet;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTotalBet() {
        return totalBet;
    }

    public int getTotalWon() {
        return totalWon;
    }

    public int getHighestWin() {
        return highestWin;
    }

    public double getWinRate() {

        if (gamesPlayed == 0) {
            return 0;
        }

        return (wins * 100.0) / gamesPlayed;
    }

    @Override
    public String toString() {

        return """
                ==============================
                Games Played : %d
                Wins         : %d
                Losses       : %d
                Total Bet    : $%d
                Total Won    : $%d
                Highest Win  : $%d
                Win Rate     : %.2f%%
                ==============================
                """.formatted(
                gamesPlayed,
                wins,
                losses,
                totalBet,
                totalWon,
                highestWin,
                getWinRate()
        );
    }
}