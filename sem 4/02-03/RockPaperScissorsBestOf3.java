import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsBestOf3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        int playerScore = 0;
        int computerScore = 0;
        int round = 1;

        System.out.println("===== ROCK PAPER SCISSORS =====");
        System.out.println("        BEST OF 3");
        System.out.println("First to win 2 rounds wins the game.\n");

        while (playerScore < 2 && computerScore < 2) {

            System.out.println("Round " + round);
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Enter your choice (1-3): ");

            int userChoice = sc.nextInt();

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice! Try again.\n");
                continue;
            }

            String player = choices[userChoice - 1];
            String computer = choices[random.nextInt(3)];

            System.out.println("You      : " + player);
            System.out.println("Computer : " + computer);

            if (player.equals(computer)) {
                System.out.println("Result : Draw!");
            }
            else if ((player.equals("Rock") && computer.equals("Scissors")) ||
                     (player.equals("Paper") && computer.equals("Rock")) ||
                     (player.equals("Scissors") && computer.equals("Paper"))) {

                System.out.println("Result : You Win this Round!");
                playerScore++;
            }
            else {
                System.out.println("Result : Computer Wins this Round!");
                computerScore++;
            }

            System.out.println("----------------------------");
            System.out.println("Score");
            System.out.println("You      : " + playerScore);
            System.out.println("Computer : " + computerScore);
            System.out.println();

            round++;
        }

        System.out.println("===== FINAL RESULT =====");

        if (playerScore == 2) {
            System.out.println("🎉 Congratulations! You Won the Best of 3 Game.");
        } else {
            System.out.println("💻 Computer Won the Best of 3 Game.");
        }

        sc.close();
    }
}