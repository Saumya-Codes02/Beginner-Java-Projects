package slotmachine.model;

public class Player {

    private String name;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }


    public void deposit(int amount){

        if(amount > 0){

            balance += amount;

        }

    }

    public boolean withdraw(int amount) {

        if(amount > balance)
            return false;

        balance -= amount;
        return true;
    }

    public void addWinnings(int amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "\nPlayer : " + name +
                "\nBalance : $" + balance;
    }
}