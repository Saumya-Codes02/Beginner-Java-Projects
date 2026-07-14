package slotmachine.ui;

import slotmachine.model.Player;
import slotmachine.model.Symbol;

public class ConsoleUI {

    public void showWelcome() {

        System.out.println("========================================");
        System.out.println("      JAVA SLOT MACHINE");
        System.out.println("========================================");
        System.out.println("Symbols:");
        System.out.println("🍒 🍉 🍋 🔔 ⭐");
        System.out.println();
    }

    public void showBalance(Player player) {

        System.out.println("----------------------------------------");
        System.out.println("Current Balance : $" + player.getBalance());
        System.out.println("----------------------------------------");
    }

    public void printRow(Symbol[] row) {

        System.out.println("+-----------------------+");

        System.out.printf("| %s | %s | %s |\n",
                row[0].getIcon(),
                row[1].getIcon(),
                row[2].getIcon());

        System.out.println("+-----------------------+");
    }

    public void showWin(int payout) {

        System.out.println();
        System.out.println("🎉 Congratulations!");
        System.out.println("You won $" + payout);
    }

    public void showLoss(int bet) {

        System.out.println();
        System.out.println("You lost $" + bet);
    }

    public void goodbye(Player player) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Thanks for playing!");
        System.out.println("Final Balance : $" + player.getBalance());
        System.out.println("========================================");
    }
    public void showMenu() {

        System.out.println();
        System.out.println("========== MENU ==========");
        System.out.println("1. Play");
        System.out.println("2. Deposit Money");
        System.out.println("3. Statistics");
        System.out.println("4. Save Game");
        System.out.println("5. Exit");
        System.out.println("==========================");
    }
}