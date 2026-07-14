package slotmachine.model;

import java.io.Serializable;

public enum Symbol implements Serializable {

    CHERRY("🍒", 3, 2, 35),
    WATERMELON("🍉", 4, 3, 25),
    LEMON("🍋", 5, 4, 18),
    BELL("🔔", 10, 5, 15),
    STAR("⭐", 20, 10, 7);

    private final String icon;
    private final int threeMatchMultiplier;
    private final int twoMatchMultiplier;
    private final int weight;

    Symbol(String icon,
           int threeMatchMultiplier,
           int twoMatchMultiplier,
           int weight) {

        this.icon = icon;
        this.threeMatchMultiplier = threeMatchMultiplier;
        this.twoMatchMultiplier = twoMatchMultiplier;
        this.weight = weight;
    }

    public String getIcon() {
        return icon;
    }

    public int getThreeMatchMultiplier() {
        return threeMatchMultiplier;
    }

    public int getTwoMatchMultiplier() {
        return twoMatchMultiplier;
    }

    public int getWeight() {
        return weight;
    }

    public static int getTotalWeight() {

        int total = 0;

        for (Symbol symbol : values()) {
            total += symbol.weight;
        }

        return total;
    }

    public static Symbol getRandomSymbol(int randomValue) {

        int cumulative = 0;

        for (Symbol symbol : values()) {

            cumulative += symbol.weight;

            if (randomValue < cumulative) {
                return symbol;
            }
        }

        return CHERRY;
    }

    @Override
    public String toString() {
        return icon;
    }
}