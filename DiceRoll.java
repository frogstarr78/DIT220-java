import java.awt.*;
import java.applet.*;

class InvalidDiceValueException extends Exception {

	public InvalidDiceValueException(int dieValue) {
		super("Di[c]e result [" + dieValue + "] invalid\n");
	}
}

class DiceRoll {

	public static int randomDieNumber() throws InvalidDiceValueException {
		int res;
		res = (((int)(100 * Math.random())) % 6)+1;

		if(res < 1 || res > 6) {
			throw new InvalidDiceValueException(res);
		}
		return res;
	}

	public static void write(Object out) {
		System.out.print(out);
	}

	public static int rollUntilMaxNumber(int maxNum) throws InvalidDiceValueException {
		int numberOfRolls = 1;
		int die1=0, die2=0, currentTotal=0;

		if(maxNum < 2 || maxNum > 12) {
			throw new InvalidDiceValueException(maxNum);
		}

		try {
			write("Roll # " + numberOfRolls);
			write("\n");
			die1 = randomDieNumber();
			write("Die 1: ");
			write(die1);
			write("\n");
			die2 = randomDieNumber();
			write("Die 2: ");
			write(die2);
			write("\n");

			currentTotal = die1 + die2;
			write("Total: " + currentTotal);
			write("\n");

		} catch(InvalidDiceValueException e) {
			write(e);
			return new InvalidDiceValueException(e);
		}

		return currentTotal;
	}

	public static void main(String args[]) {
		int numberOfTries = 0;
		int maxNumber = 12;
		boolean continueTrying = false;
		int currentTotal = 0;

		do {
			try {
				rollUntilMaxNumber(maxNumber);
				if(currentTotal == maxNumber) {
					write("It took " + numberOfTries + " tries to roll " + maxNumber);
					write("\n");
					continueTrying = true;
					break;
				}
				numberOfTries++;
				continueTrying = Randomer.getBool("Roll again? [Yn] ");
			} catch(InvalidDiceValueException e) {
				write(e);
				break;
			}
		} while (continueTrying);
	}

}

//public class name-of-applet extends applet {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Thu Oct 26 22:21:32 PDT 2006
	Chapter 3 Program 6
*/

/*
	public void paint(graphics g) {
		// statements
	}
 
}
*/
