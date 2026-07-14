package slotmachine.model;

import java.io.Serializable;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int balance;

    public Player(String name, int balance) {

        if (name == null || name.isBlank()) {
            this.name = "Player";
        } else {
            this.name = name.trim();
        }

        this.balance = Math.max(balance, 0);
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        balance += amount;
    }

    public void addWinnings(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Winning amount cannot be negative.");
        }

        balance += amount;
    }

    public void deductBet(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Bet amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        balance -= amount;
    }

    public boolean canBet(int amount) {
        return amount > 0 && amount <= balance;
    }

    public void setBalance(int balance) {
        this.balance = Math.max(balance, 0);
    }

    @Override
    public String toString() {

        return "Player{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}