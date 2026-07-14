package slotmachine.service;

import slotmachine.model.GameState;

import java.io.*;

public class FileManager {

    private static final String SAVE_DIRECTORY = "save";
    private static final String SAVE_FILE = SAVE_DIRECTORY + "/game.dat";
    private static final String LOG_FILE = SAVE_DIRECTORY + "/logs.txt";

    public FileManager() {

        createDirectory();

    }

    private void createDirectory() {

        File directory = new File(SAVE_DIRECTORY);

        if (!directory.exists()) {

            directory.mkdirs();

        }

    }

    public void saveGame(GameState state) throws IOException {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(SAVE_FILE))) {

            output.writeObject(state);

        }

    }

    public GameState loadGame()
            throws IOException,
            ClassNotFoundException {

        File file = new File(SAVE_FILE);

        if (!file.exists()) {

            return null;

        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            return (GameState) input.readObject();

        }

    }

    public void writeLog(String message) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(LOG_FILE, true))) {

            writer.write(message);
            writer.newLine();
            writer.write("---------------------------------------");
            writer.newLine();

        } catch (IOException ignored) {

        }

    }

    public boolean saveExists() {

        return new File(SAVE_FILE).exists();

    }

}