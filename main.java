import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean isGuessed = false;
		Random random = new Random();
		int randomNumber  = random.nextInt(101);
		
		System.out.println("Welcome to the number guessing game!\nI am thinking of a number between 1-100.");
		System.out.println("\nSelect difficulty:\n1. Easy (10 guesses)\n2. Medium (6 guesses)\n3. Hard (3 guesses)");
		
		String difficultyPick = scanner.nextLine();
		
		int numberOfGuesses = 0;
		int numberOfTries = 0;
		
		switch (difficultyPick) {
			case "1" -> numberOfGuesses = 10;
			case "2" -> numberOfGuesses = 6;
			case "3" -> numberOfGuesses = 3;
			case "" -> System.out.println("You did not enter a number.");
		}
		
		while (!isGuessed) {
			
			System.out.print("Enter your guess: ");
			String guess = scanner.nextLine();
			
			int guessAsNumber = Integer.parseInt(guess);
			
			if (!(guessAsNumber >= 1 && guessAsNumber <= 100)) { // Check in bound
				System.out.println("You need to enter a number between 1 and 100. Try again.");
			} else if ((guessAsNumber > randomNumber) && numberOfGuesses > 1) {
				System.out.print("Incorrect. Guess lower! Try again: ");
				numberOfGuesses--;
				numberOfTries++;
			} else if ((guessAsNumber < randomNumber) && numberOfGuesses > 1) {
				System.out.print("Incorrect. Guess higher! Try again: ");
				numberOfGuesses--;
				numberOfTries++;
			} else if ((guessAsNumber == randomNumber) && numberOfGuesses > 1) {
				numberOfTries++;
				System.out.println("Congratuations! You guessed the number. It took you "+ numberOfTries + " tries.");
				isGuessed = true;
			} else {
				System.out.print("You failed! The number was " + randomNumber + "!");
				isGuessed = true; // To get out of while loop
				scanner.close();
			}
		}
	}

}
