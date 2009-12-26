public class WhatsRandom extends Randomer {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Tue Oct 17 21:22:54 PDT 2006
	Chapter 4
*/

	public WhatsRandom(int howMany) {
		super(howMany);
		numberOfGuesses = 1;
		isCorrect = false;
		currentRandomInt = getNewRandomInteger();	
	}

	public int getCurrentRandomInteger () { return currentRandomInt; }

	public void guess() {
		int guess;
		write("Guess# " + numberOfGuesses + ": ");
		guess = TextIO.getlnInt();
		write("\n");
		process(guess);
		numberOfGuesses++;
	}

	protected void process (int guess) {
		String comparesTo;
		if( guess > currentRandomInt) {
			comparesTo = "less";
		} else if ( guess < currentRandomInt) {
			comparesTo = "greater";
		} else {
			isCorrect = true;
			return;
		}
		write("The random number is " + comparesTo + " than " + guess + "\n");	
	}

	public boolean isntCorrect () { return !(isCorrect); }

	public static void main(String[] args) {
		boolean userWantsToContinue = false;
		int numberOfRandoms = 0;

		do {
			while(numberOfRandoms == 0 || numberOfRandoms == 100) {
				numberOfRandoms = getInt("How many guesses would you like to make? ");
				if(numberOfRandoms == 0 || numberOfRandoms == 100)
					write("Sorry " + numberOfRandoms + " is an invalid number of options to specify.");
			}
			WhatsRandom whatsRand = new WhatsRandom(numberOfRandoms);
				
			do {
				// actually numberOfGuesses is the number of guesses the user has tried
				// numberOfRandoms is the number of guesses they are allowed before the 
				// game declares them a looser+1. :-D
				if(whatsRand.numberOfGuesses == whatsRand.numberOfRandoms+1) { break; }
				whatsRand.guess();
			} while(whatsRand.isntCorrect()); 

			if(whatsRand.isntCorrect()) {
				write("Sorry the number was " + whatsRand.getCurrentRandomInteger() + "\n");
			} else {
				write("Congratulations! You've won. The number was " + whatsRand.getCurrentRandomInteger() + "\n");
			}
			
			userWantsToContinue = getBool("Continue the WhatsRandom game? (yn): ");
		} while(userWantsToContinue);
	}
}
