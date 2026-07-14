package slotmachine.ui;

import slotmachine.model.GameResult;
import slotmachine.model.Player;
import slotmachine.model.Symbol;

public class ConsoleUI {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    public void showWelcome() {

        System.out.println(CYAN +
                """
                ==================================================
                         JAVA SLOT MACHINE
                ==================================================
                Symbols:
                🍒 🍉 🍋 🔔 ⭐
                ==================================================
                """ + RESET);
    }

    public void showMenu() {

        System.out.println("""
                
                ============== MENU ==============
                1. Play
                2. Deposit Money
                3. View Statistics
                4. Save Game
                5. Exit
                ==================================
                """);
    }

    public void showBalance(Player player) {

        System.out.println(BLUE +
                "\nCurrent Balance : $" + player.getBalance()
                + RESET);
    }

    public void printRow(Symbol[] row) {

        System.out.println();
        System.out.println("+-----------------------+");

        System.out.printf("| %s | %s | %s |\n",
                row[0].getIcon(),
                row[1].getIcon(),
                row[2].getIcon());

        System.out.println("+-----------------------+");
    }

    public void displayResult(GameResult result) {

        printRow(result.getRow());

        if (result.isJackpot()) {

            System.out.println(YELLOW);
            System.out.println("★★★★★★★★★★★★★★★★★★★★");
            System.out.println("      JACKPOT!!!");
            System.out.println("★★★★★★★★★★★★★★★★★★★★");
            System.out.println(RESET);

        }

        if (result.isWin()) {

            System.out.println(GREEN +
                    "You Won $" + result.getPayout()
                    + RESET);

        } else {

            System.out.println(RED +
                    "You Lost $" + result.getBet()
                    + RESET);

        }

    }

    public void showMessage(String message) {

        System.out.println(message);

    }

    public void showError(String message) {

        System.out.println(RED + message + RESET);

    }

    public void goodbye(Player player) {

        System.out.println(CYAN +
                """
                
                ====================================
                     THANK YOU FOR PLAYING
                ====================================
                """ + RESET);

        System.out.println("Player : " + player.getName());
        System.out.println("Final Balance : $" + player.getBalance());

    }

}