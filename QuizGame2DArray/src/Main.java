import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String LINE = "========================================";

        String[] questions = {
                "What is the main function of a router?",
                "Which part of the computer is considered the brain?",
                "What year was Facebook launched?",
                "Who is known as the father of computer?",
                "What was the first high-level programming language?"
        };

        String[][] options = {
                {
                        "1. Storing Files",
                        "2. Encrypting Data",
                        "3. Directing Internet Traffic",
                        "4. Managing Passwords"
                },
                {
                        "1. CPU",
                        "2. Hard Drive",
                        "3. RAM",
                        "4. GPU"
                },
                {
                        "1. 2000",
                        "2. 2004",
                        "3. 2006",
                        "4. 2008"
                },
                {
                        "1. Narendra Modi",
                        "2. Bill Gates",
                        "3. Alan Turing",
                        "4. Charles Babbage"
                },
                {
                        "1. COBOL",
                        "2. C",
                        "3. Fortran",
                        "4. Assembly"
                }
        };

        int[] answers = {3, 1, 2, 4, 3};

        int score = 0;

        System.out.println(LINE);
        System.out.println("          JAVA QUIZ GAME");
        System.out.println(LINE);

        for (int i = 0; i < questions.length; i++) {

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Question " + (i + 1) + "/" + questions.length);
            System.out.println("----------------------------------------");

            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            int guess;

            while (true) {
                System.out.print("Enter your answer (1-4): ");

                if (sc.hasNextInt()) {
                    guess = sc.nextInt();

                    if (guess >= 1 && guess <= 4) {
                        break;
                    } else {
                        System.out.println("❌ Please enter a number between 1 and 4.");
                    }

                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    sc.next();
                }
            }

            if (guess == answers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect!");
                System.out.println("Correct Answer: " + options[i][answers[i] - 1]);
            }
        }

        double percentage = (score * 100.0) / questions.length;

        System.out.println();
        System.out.println(LINE);
        System.out.println("          QUIZ COMPLETED");
        System.out.println(LINE);

        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.length - score));
        System.out.println("Total Questions : " + questions.length);
        System.out.printf("Percentage      : %.2f%%\n", percentage);

        System.out.println();

        if (percentage == 100) {
            System.out.println("🏆 Grade: A+");
            System.out.println("Outstanding! Perfect score.");
        } else if (percentage >= 80) {
            System.out.println("🥇 Grade: A");
            System.out.println("Excellent work!");
        } else if (percentage >= 60) {
            System.out.println("🥈 Grade: B");
            System.out.println("Good job! Keep improving.");
        } else if (percentage >= 40) {
            System.out.println("🥉 Grade: C");
            System.out.println("Fair attempt. Practice more.");
        } else {
            System.out.println("📚 Grade: F");
            System.out.println("Keep practicing! You'll improve.");
        }

        sc.close();
    }
}