import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = {"rock", "paper", "scissors"};

        int wins = 0;
        int losses = 0;
        int ties = 0;

        String playAgain;

        System.out.println("==================================");
        System.out.println("     ROCK PAPER SCISSORS");
        System.out.println("==================================");

        do {

            String playerChoice;

            // Get a valid player choice
            while (true) {
                System.out.print("\nEnter your move (rock, paper, scissors): ");
                playerChoice = sc.nextLine().trim().toLowerCase();

                if (playerChoice.equals("rock") ||
                        playerChoice.equals("paper") ||
                        playerChoice.equals("scissors")) {
                    break;
                }

                System.out.println("❌ Invalid choice. Please enter rock, paper, or scissors.");
            }

            // Computer choice
            String computerChoice = choices[rand.nextInt(choices.length)];

            System.out.println("You chose      : " + capitalize(playerChoice));
            System.out.println("Computer chose : " + capitalize(computerChoice));

            // Determine winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("🤝 It's a tie!");
                ties++;
            } else if (
                    (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                            (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                            (playerChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("🎉 You win!");
                wins++;
            } else {
                System.out.println("💻 Computer wins!");
                losses++;
            }

            // Display current score
            System.out.println("\n---------- SCORE ----------");
            System.out.println("Wins   : " + wins);
            System.out.println("Losses : " + losses);
            System.out.println("Ties   : " + ties);
            System.out.println("---------------------------");

            // Ask to play again
            while (true) {
                System.out.print("\nPlay again? (yes/no): ");
                playAgain = sc.nextLine().trim().toLowerCase();

                if (playAgain.equals("yes") || playAgain.equals("no")) {
                    break;
                }

                System.out.println("❌ Invalid input. Please enter yes or no.");
            }

        } while (playAgain.equals("yes"));

        // Final Summary
        System.out.println("\n==================================");
        System.out.println("         GAME OVER");
        System.out.println("==================================");
        System.out.println("Final Score");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Ties   : " + ties);

        if (wins > losses) {
            System.out.println("\n🏆 Overall Result: You won the series!");
        } else if (losses > wins) {
            System.out.println("\n😢 Overall Result: Computer won the series!");
        } else {
            System.out.println("\n🤝 Overall Result: It's a draw!");
        }

        System.out.println("\nThanks for playing!");

        sc.close();
    }

    // Capitalize first letter
    public static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}