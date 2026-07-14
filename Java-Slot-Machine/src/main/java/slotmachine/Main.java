package slotmachine;

import slotmachine.service.Game;

public class Main {

    public static void main(String[] args) {

        try {

            Game game = new Game();

            game.start();

        } catch (Exception e) {

            System.out.println("Unexpected error occurred.");

            e.printStackTrace();

        }

    }

}