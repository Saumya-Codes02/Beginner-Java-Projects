package slotmachine.model;

public class Statistics {

    private int gamesPlayed;
    private int wins;
    private int losses;
    private int totalBet;
    private int totalWon;
    private int highestWin;

    public void recordWin(int bet, int payout){

        gamesPlayed++;
        wins++;

        totalBet += bet;
        totalWon += payout;

        if(payout > highestWin)
            highestWin = payout;
    }

    public void recordLoss(int bet){

        gamesPlayed++;
        losses++;

        totalBet += bet;
    }

    public void display(){

        System.out.println("\n========== STATISTICS ==========");
        System.out.println("Games Played : " + gamesPlayed);
        System.out.println("Wins         : " + wins);
        System.out.println("Losses       : " + losses);
        System.out.println("Total Bet    : $" + totalBet);
        System.out.println("Total Won    : $" + totalWon);
        System.out.println("Highest Win  : $" + highestWin);

        if(gamesPlayed != 0){
            double winRate = (wins * 100.0) / gamesPlayed;
            System.out.printf("Win Rate     : %.2f%%\n", winRate);
        }

        System.out.println("===============================\n");
    }
}