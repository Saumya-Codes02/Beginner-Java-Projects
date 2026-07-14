package slotmachine.service;

import slotmachine.model.GameResult;
import slotmachine.model.Symbol;

import java.util.Random;

public class SlotMachine {

    private static final int JACKPOT_BONUS = 5000;

    private final Random random = new Random();

    public GameResult playRound(int bet) {

        Symbol[] row = spin();

        int payout = calculatePayout(row, bet);

        boolean jackpot = false;

        if (isThreeMatch(row) && row[0] == Symbol.STAR) {

            payout += JACKPOT_BONUS;
            jackpot = true;

        }

        return new GameResult(
                row,
                bet,
                payout,
                jackpot
        );

    }

    private Symbol[] spin() {

        Symbol[] row = new Symbol[3];

        for (int i = 0; i < row.length; i++) {

            row[i] = randomSymbol();

        }

        return row;

    }

    private Symbol randomSymbol() {

        int totalWeight = Symbol.getTotalWeight();

        int value = random.nextInt(totalWeight);

        return Symbol.getRandomSymbol(value);

    }

    private int calculatePayout(Symbol[] row,
                                int bet) {

        if (isThreeMatch(row)) {

            return bet * row[0].getThreeMatchMultiplier();

        }

        if (row[0] == row[1]) {

            return bet * row[0].getTwoMatchMultiplier();

        }

        if (row[1] == row[2]) {

            return bet * row[1].getTwoMatchMultiplier();

        }

        if (row[0] == row[2]) {

            return bet * row[0].getTwoMatchMultiplier();

        }

        return 0;

    }

    private boolean isThreeMatch(Symbol[] row) {

        return row[0] == row[1]
                && row[1] == row[2];

    }

}