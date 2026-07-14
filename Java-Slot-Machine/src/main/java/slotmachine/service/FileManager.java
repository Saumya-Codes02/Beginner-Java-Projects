package slotmachine.service;

import slotmachine.model.Player;

import java.io.*;

public class FileManager {

    private static final String SAVE_FILE = "save/player.dat";
    private static final String LOG_FILE = "save/logs.txt";

    public void savePlayer(Player player) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(SAVE_FILE))) {

            writer.write(player.getName());
            writer.newLine();

            writer.write(String.valueOf(player.getBalance()));

        } catch (IOException e) {

            System.out.println("Unable to save game.");

        }

    }

    public Player loadPlayer() {

        File file = new File(SAVE_FILE);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String name = reader.readLine();

            int balance = Integer.parseInt(reader.readLine());

            return new Player(name, balance);

        } catch (Exception e) {

            return null;

        }

    }

    public void writeLog(String message) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(LOG_FILE, true))) {

            writer.write(message);

            writer.newLine();

        } catch (IOException ignored) {

        }

    }

}