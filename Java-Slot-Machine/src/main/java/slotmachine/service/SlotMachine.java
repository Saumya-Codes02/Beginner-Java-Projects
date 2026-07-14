package slotmachine.service;

import slotmachine.model.Symbol;

import java.util.Random;

public class SlotMachine {

    private final Random random = new Random();

    public Symbol[] spin() {

        Symbol[] row = new Symbol[3];
        Symbol[] values = Symbol.values();

        for (int i = 0; i < row.length; i++) {
            row[i] = values[random.nextInt(values.length)];
        }

        return row;
    }

    public int calculatePayout(Symbol[] row, int bet) {

        // Three matching symbols
        if (row[0] == row[1] && row[1] == row[2]) {
            return bet * row[0].getThreeMatchMultiplier();
        }

        // Any two matching symbols
        if (row[0] == row[1] || row[0] == row[2]) {
            return bet * row[0].getTwoMatchMultiplier();
        }

        if (row[1] == row[2]) {
            return bet * row[1].getTwoMatchMultiplier();
        }

        return 0;
    }
}