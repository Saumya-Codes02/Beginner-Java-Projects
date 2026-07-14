package slotmachine.service;

import slotmachine.model.Player;
import slotmachine.model.Statistics;
import slotmachine.model.Symbol;
import slotmachine.ui.ConsoleUI;

import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    private final SlotMachine slotMachine = new SlotMachine();
    private final ConsoleUI ui = new ConsoleUI();
    private final Statistics statistics = new Statistics();

    private Player player;

    public void start() {

        ui.showWelcome();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        player = new Player(name, 100);

        boolean running = true;

        while (running && player.getBalance() > 0) {

            ui.showBalance(player);

            int bet = getBet();

            player.withdraw(bet);

            spinAnimation();

            Symbol[] row = slotMachine.spin();

            ui.printRow(row);

            int payout = slotMachine.calculatePayout(row, bet);

            if (payout > 0) {

                player.addWinnings(payout);

                statistics.recordWin(bet, payout);

                ui.showWin(payout);

            } else {

                statistics.recordLoss(bet);

                ui.showLoss(bet);

            }

            running = playAgain();
        }

        statistics.display();

        ui.goodbye(player);

        scanner.close();
    }

    private int getBet() {

        while (true) {

            System.out.print("Enter bet amount: ");

            int bet = scanner.nextInt();

            scanner.nextLine();

            if (bet <= 0) {

                System.out.println("Bet must be greater than zero.");

                continue;
            }

            if (bet > player.getBalance()) {

                System.out.println("Insufficient balance.");

                continue;
            }

            return bet;
        }
    }

    private boolean playAgain() {

        System.out.print("\nPlay again? (Y/N): ");

        String answer = scanner.nextLine().trim().toUpperCase();

        return answer.equals("Y");
    }

    private void spinAnimation() {

        System.out.print("\nSpinning");

        try {

            for (int i = 0; i < 3; i++) {

                Thread.sleep(500);

                System.out.print(".");

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

        System.out.println("\n");
    }

}