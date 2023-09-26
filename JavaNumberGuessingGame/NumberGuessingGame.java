import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random());
        int attempts = 5;
        int i, guess;

        System.out.println("Guess a number between 1 to 100 accurately within 5 attempts.");

        for (i = 0; i < attempts; i++) {
            System.out.println("Enter your guess: ");
            guess = input.nextInt();

            if (number == guess) {
                System.out.println("Correct!!");
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
    }
}