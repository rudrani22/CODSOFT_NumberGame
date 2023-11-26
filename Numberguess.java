import java.util.Scanner;
import java.util.Random;

public class Numberguess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 50;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number guessing Game!");
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                int difference = Math.abs(generatedNumber - userGuess);
                if (difference >= 50) {
                    System.out.println("Hint: You're very far from the number!");
                } else if (difference >= 30) {
                    System.out.println("Hint: You're quite far from the number.");
                } else if (difference >= 15) {
                    System.out.println("Hint: You're getting closer, but still a bit far.");
                } else if (difference >= 5) {
                    System.out.println("Hint: You're getting closer!");
                } else {
                    System.out.println("Hint: You're very close to the number!");
                }

                if (attempts < attemptsLimit) {
                    System.out.println("Try again. Remaining attempts: " + (attemptsLimit - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println(
                        "Sorry, you've reached the maximum number of attempts. The number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! Your final score is: " + score);
        scanner.close();
    }
}
