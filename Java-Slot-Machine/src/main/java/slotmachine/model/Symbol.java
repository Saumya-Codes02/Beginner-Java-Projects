package slotmachine.model;

public enum Symbol {

    CHERRY("🍒", 3, 2),
    WATERMELON("🍉", 4, 3),
    LEMON("🍋", 5, 4),
    BELL("🔔", 10, 5),
    STAR("⭐", 20, 10);

    private final String icon;
    private final int threeMatchMultiplier;
    private final int twoMatchMultiplier;

    Symbol(String icon, int threeMatchMultiplier, int twoMatchMultiplier) {
        this.icon = icon;
        this.threeMatchMultiplier = threeMatchMultiplier;
        this.twoMatchMultiplier = twoMatchMultiplier;
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
}