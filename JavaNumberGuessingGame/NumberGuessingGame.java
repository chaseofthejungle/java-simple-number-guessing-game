import java.util.ArrayList;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int i, guess, attempts, highestValue = 0;
        ArrayList<Integer> guesses = new ArrayList<Integer>();
        char keepPlaying = 'y';

        System.out.println("Your Objective: \t Accurately guess a whole number between 1 and a number that you define.");

        while (keepPlaying == 'y' || keepPlaying == 'Y') {
            System.out.println("Enter the highest possible value for the number to guess (or Q to Quit).");
            if (input.hasNextInt()) {
                highestValue = input.nextInt();
            } else if (input.hasNext("Q") || input.hasNext("q")) {
                System.out.println("Thank you for playing.");
                System.exit(0);
            }

            int number = 1 + (int) (highestValue * Math.random());

            System.out.println("How many attempts would you like to have at guessing the number?");
            attempts = input.nextInt();

            for (i = 0; i < attempts; i++) {
                System.out.println("Enter your guess: ");
                guess = input.nextInt();
                guesses.add(guess);

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

            System.out.println("Your guesses were: " + guesses);
            guesses.clear();
            System.out.println("Would you like to play again? (y = yes, n = no)");
            keepPlaying = input.next().charAt(0);

            while (keepPlaying != 'y' && keepPlaying != 'Y' && keepPlaying != 'n' && keepPlaying != 'N') {
                System.out.println("Invalid Answer. Would you like to play again? (y = yes, n = no)");
                keepPlaying = input.next().charAt(0);
            }
        }
    }
}