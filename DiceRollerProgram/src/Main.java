import java.util.Random;
import java.util.Scanner;

public class Main {

    // ASCII Dice Faces
    static final String DICE1 = """
             -------
           |        |
           |   ●   |
           |        |
             -------
            """;

    static final String DICE2 = """
             -------
           | ●     |
           |        |
           |     ● |
             -------
            """;

    static final String DICE3 = """
             -------
           | ●     |
           |   ●   |
           |     ● |
             -------
            """;

    static final String DICE4 = """
             -------
           | ●   ● |
           |         |
           | ●   ● |
             -------
            """;

    static final String DICE5 = """
             -------
           | ●   ● |
           |    ●   |
           | ●   ● |
             -------
            """;

    static final String DICE6 = """
             -------
           | ●   ● |
           | ●   ● |
           | ●   ● |
             -------
            """;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numOfDice;
        int totalRoll = 0;

        System.out.print("Enter the number of dice to roll (1-20): ");

        // Input Validation
        if (!sc.hasNextInt()) {
            System.out.println("❌ Invalid input! Please enter a whole number.");
            sc.close();
            return;
        }

        numOfDice = sc.nextInt();

        // Range Validation
        if (numOfDice <= 0) {
            System.out.println("❌ Number of dice must be greater than 0.");
        } else if (numOfDice > 20) {
            System.out.println("❌ Maximum 20 dice can be rolled at once.");
        } else {

            System.out.println("\n🎲 Rolling " + numOfDice + " dice...\n");

            for (int i = 1; i <= numOfDice; i++) {

                int roll = rand.nextInt(1, 7);

                System.out.println("Die " + i + ":");
                printDie(roll);
                System.out.println("Rolled: " + roll + "\n");

                totalRoll += roll;
            }

            System.out.println("======================");
            System.out.println("Total Roll: " + totalRoll);
            System.out.println("======================");
        }

        sc.close();
    }

    static void printDie(int roll) {

        switch (roll) {
            case 1 -> System.out.println(DICE1);
            case 2 -> System.out.println(DICE2);
            case 3 -> System.out.println(DICE3);
            case 4 -> System.out.println(DICE4);
            case 5 -> System.out.println(DICE5);
            case 6 -> System.out.println(DICE6);
            default -> System.out.println("Invalid roll.");
        }
    }
}