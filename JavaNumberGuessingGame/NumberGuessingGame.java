import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());
        int attempts = 5;
        int i, guess;
        char keepPlaying = 'y';

        System.out.println("Guess a number between 1 to 100 accurately within 5 attempts.");

        while (keepPlaying == 'y' || keepPlaying == 'Y') {
            for (i = 0; i < attempts; i++) {
                System.out.println("Enter your guess: ");
                guess = input.nextInt();

                if (number == guess) {
                    System.out.println("Correct! It took you " + (i + 1) + " attempts to get the answer!");
                    break;
                } else if (number > guess && i != attempts - 1) {
                    System.out.println(guess + " is too low.");
                } else if (number < guess && i != attempts - 1) {
                    System.out.println(guess + " is too high.");
                }
            }

            if (i == attempts) {
                System.out.println("Game Over! You ran out of attempts.");
                System.out.println("The number was: " + number);
            }

            System.out.println("Would you like to play again? (y = yes, n = no)");
            keepPlaying = input.next().charAt(0);
        }
    }
}