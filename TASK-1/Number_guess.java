import java.util.Random;
import java.util.*;

public class Number_guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int round = 1;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;
            int maxAttempts = 10;

            System.out.println("Round " + round);
            System.out.println("Guess the number between 1 and 100");

            while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                numberOfAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Higher!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Lower!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + numberOfAttempts + " attempts.");
                    hasGuessedCorrectly = true;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The number was " + numberToGuess);
            }

            int score = maxAttempts - numberOfAttempts + 1;
            totalScore += score;

            System.out.println("Your score for this round is: " + score);
            System.out.println("Your total score is: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
            round++;
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        
    }
}
