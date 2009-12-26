import java.awt.*;
import java.applet.*;

public class Roulette {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Tue Oct 24 22:18:18 PDT 2006
	Test
*/

	public static int getNewRandom(int seed) {
		return (int)((101*Math.random())+1) % seed;	
	}

	public static boolean calculateWinner(int guess, String player, int highest, int currentRandomNumber) {
		boolean foundWinner = false;
		Randomer.write(player + "'s guess is " + guess);
		Randomer.write("\n");

		if(currentRandomNumber == guess) {
			foundWinner = true;
			if(player == "user") {
				Randomer.write("Sorry you loose.\n");
				Randomer.write("The random number from 0 to [" + highest + "] was " + currentRandomNumber);
				Randomer.write("\n");
			} else {
				Roulette.writeWin(highest, currentRandomNumber);
			}
		}
		return foundWinner;
	}

	public static void writeWin(int highest, int currentRandomNumber) {
		Randomer.write("You win!\n");	
		Randomer.write("The computer got the random number.\n");
		Randomer.write("From 0 to [" + highest + "] was " + currentRandomNumber);
		Randomer.write("\n");
	}

	public static void main(String[] args) {
		int highest, currentRandomNumber, guess;
		boolean playAgain, foundWinner, continueGuessing = false;
		char starter;
		String player;
		Randomer.write("Enter the highest number of possibilities\n");
		Randomer.write("Continue until you think the computer will loose\n");
		Randomer.write("aka the computer finds the random number\n");
		Randomer.write("If the computer doesn't loose though, you will\n");
		Randomer.write("Who will go first? ");
		Randomer.write("\n");

		do {
			starter = Randomer.getChar("Enter [Cc] for computer or [Uu] user? ");
			highest = Randomer.getInt("Highest number? ");

			player = (starter == 'c' || starter == 'C') ? "computer" : "user";

			currentRandomNumber = Roulette.getNewRandom(highest);

			do {
				
				guess = Roulette.getNewRandom(highest);
				foundWinner = Roulette.calculateWinner(guess, player, highest, currentRandomNumber);
				if(foundWinner) { 
					player = ""; 
					break; 
				}

				player = (player == "computer") ? "user" : "computer";
				guess = Roulette.getNewRandom(highest);
				foundWinner = Roulette.calculateWinner(guess, player, highest, currentRandomNumber);
				if(foundWinner) { 
					player = ""; 
					break; 
				}

				continueGuessing = Randomer.getBool("Care to continue? ");
			} while(continueGuessing);

			if(player == "user") {
				// condition will be met when the foundWinner is true
				foundWinner = Roulette.calculateWinner(Roulette.getNewRandom(highest), "computer", highest, currentRandomNumber);
				if(!foundWinner) {
					Roulette.writeWin(highest, currentRandomNumber);
				}
			}

			playAgain = Randomer.getBool("Play again? ");
		} while(playAgain);

	} 
}
