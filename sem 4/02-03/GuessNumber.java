import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int guess = 0;
        boolean win = false;
        
        System.out.println("Guess a number between 1 and 100:");
        
        while (!win) {
            guess = scanner.nextInt();
            numberOfTries++;
            
            if (guess == numberToGuess) {
                win = true;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again:");
            } else {
                System.out.println("Too high! Try again:");
            }
        }
        
        System.out.println("You win! The number was " + numberToGuess);
        System.out.println("It took you " + numberOfTries + " tries.");
        
        scanner.close();
    }
}