class CollatzConjecture extends Randomer {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Tue Oct 17 21:22:54 PDT 2006
	Chapter 4
*/

	public CollatzConjecture(int currentInt) {
		super(currentInt);
		currentRandomInt = currentInt;	
	}

	protected void process() {
		write("The current number is ");
		write(currentRandomInt);
		write("\n");
		int N=currentRandomInt;

		while(N != 1) {
			
			write("Sequence # (" + numberOfSequences + ") ");
			write(N);
			write("\n");

			if(N%2 == 1) {
				N = 3*N+1;	
			} else {
				N = N/2;	
			}
			numberOfSequences++;
		}

		write("It took " + numberOfSequences + " calculations before " + currentRandomInt + " reached 1");
		write("\n");
	}

	public static void main(String[] args) {
		boolean userWantsToContinue = false;
		int numberOfRandoms;
		int currentInt;

		do {
			boolean userEnterNumberOption = getBool("Would you like to enter a number?\n" + 
				"(If you choose no a random number will be selected for you.)\n" + 
				"[Yn]: ");
			if(userEnterNumberOption) {
				currentInt = getInt("What's the number? ");
				write("\n");
			} else {
				currentInt = getNewRandomInteger();	
			}
			CollatzConjecture collatzConjecture = new CollatzConjecture(currentInt);
			collatzConjecture.process();

			userWantsToContinue = getBool("Continue seeing output from CollatzConjecture? (yn): ");
		} while(userWantsToContinue);
	}
}
