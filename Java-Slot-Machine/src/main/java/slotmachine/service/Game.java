package slotmachine.service;

import  slotmachine.model.GameResult;
import  slotmachine.model.GameState;
import  slotmachine.model.Player;
import  slotmachine.model.Statistics;
import  slotmachine.ui.ConsoleUI;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private static final int STARTING_BALANCE = 100;

    private final Scanner scanner;
    private final ConsoleUI ui;
    private final SlotMachine slotMachine;
    private final FileManager fileManager;

    private Player player;
    private Statistics statistics;

    public Game() {

        scanner = new Scanner(System.in);
        ui = new ConsoleUI();
        slotMachine = new SlotMachine();
        fileManager = new FileManager();

    }

    public void start() {

        ui.showWelcome();

        initializePlayer();

        boolean running = true;

        while (running) {

            ui.showBalance(player);

            ui.showMenu();

            int choice = readInt("Enter choice : ");

            switch (choice) {

                case 1 -> playGame();

                case 2 -> depositMoney();

                case 3 -> System.out.println(statistics);

                case 4 -> saveGame();

                case 5 -> {

                    saveGame();

                    running = false;

                }

                default ->

                        ui.showError("Invalid Choice.");

            }

            if (player.getBalance() <= 0) {

                ui.showError("You have no money left.");

                running = false;

            }

        }

        ui.goodbye(player);

        scanner.close();

    }

    private void initializePlayer() {

        try {

            if (fileManager.saveExists()) {

                System.out.print("Load previous game? (Y/N): ");

                String answer = scanner.nextLine().trim().toUpperCase();

                if (answer.equals("Y")) {

                    GameState state = fileManager.loadGame();

                    if (state != null) {

                        player = state.getPlayer();

                        statistics = state.getStatistics();

                        ui.showMessage("Game Loaded Successfully.");

                        return;

                    }

                }

            }

        } catch (Exception e) {

            ui.showError("Unable to load saved game.");

        }

        System.out.print("Enter Player Name : ");

        String name = scanner.nextLine();

        if (name.isBlank()) {

            name = "Player";

        }

        player = new Player(name, STARTING_BALANCE);

        statistics = new Statistics();

    }

    private void playGame() {

        if (player.getBalance() <= 0) {

            ui.showError("Insufficient Balance.");

            return;

        }

        int bet = getBet();

        if (bet == -1) {

            return;

        }

        try {

            player.deductBet(bet);

        } catch (IllegalArgumentException e) {

            ui.showError(e.getMessage());

            return;

        }

        spinAnimation();

        GameResult result = slotMachine.playRound(bet);

        if (result.isWin()) {

            player.addWinnings(result.getPayout());

            statistics.recordWin(bet, result.getPayout());

        } else {

            statistics.recordLoss(bet);

        }

        ui.displayResult(result);

        fileManager.writeLog(result.toString());

    }

    private int getBet() {

        while (true) {

            int bet = readInt("Enter Bet Amount : ");

            if (bet <= 0) {

                ui.showError("Bet must be greater than zero.");

                continue;

            }

            if (!player.canBet(bet)) {

                ui.showError("Insufficient Balance.");

                continue;

            }

            return bet;

        }

    }

    private void depositMoney() {

        int amount = readInt("Deposit Amount : ");

        if (amount <= 0) {

            ui.showError("Invalid Amount.");

            return;

        }

        try {

            player.deposit(amount);

            ui.showMessage("Deposit Successful.");

        } catch (IllegalArgumentException e) {

            ui.showError(e.getMessage());

        }

    }
    private void saveGame() {

        try {

            GameState state = new GameState(player, statistics);

            fileManager.saveGame(state);

            ui.showMessage("Game Saved Successfully.");

        } catch (IOException e) {

            ui.showError("Failed to save game.");

        }

    }

    private int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                ui.showError("Please enter a valid number.");

            }

        }

    }

    private void spinAnimation() {

        System.out.print("Spinning");

        try {

            for (int i = 0; i < 5; i++) {

                Thread.sleep(300);

                System.out.print(".");

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

        System.out.println();

    }

}