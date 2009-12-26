class MultiProgram {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Thu Oct 19 23:19:32 PDT 2006
	Chapter 4
*/


	public static void main(String[] args) {
		boolean doContinue = true;
		char option;

		do {	
			option = Randomer.getChar(
									"What would you like to do?\n" +
									"[Gg] Play the guessing game. \n" +
									"[Cc] See the output of Collatz Conjecture. \n" +
									"[Hh] Get the highest and lowest numbers from a random selection. \n" + 
									"Please enter the character to the left of the descriptions: "
									);
			switch(option) {
				case 'G':
				case 'g':
					// source in WhatsRandom.java extends Randomer.java
					WhatsRandom.main(args);
					break;
				case 'C':
				case 'c':
					// source in CollatzConjecture.java extends Randomer.java
					CollatzConjecture.main(args);
					break;
				case 'H':
				case 'h':
					// source in HighLowRandom.java extends Randomer.java
					HighLowRandom.main(args);
					break;
				default:
					Randomer.write("Unrecognized option.\n");
			}
			doContinue = Randomer.getBool("Would you like another option? [Yn]");

		} while(doContinue == true);

		Randomer.write("Thank you for using this app.");
	}
}
