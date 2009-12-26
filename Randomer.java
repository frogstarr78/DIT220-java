public class Randomer {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Thu Oct 19 21:34:42 PDT 2006
	Chapter 4
*/
	int numberOfGuesses;
	public int currentRandomInt;
	int numberOfSequences = 0;
	public int numberOfRandoms;
	public int[] randoms;
	boolean isCorrect;

	public Randomer (int howMany) {
		numberOfRandoms = howMany;
	}

	protected void process () {}

	public static int getNewRandomInteger(){
		return (int)(101 * Math.random());
	}
	
	public static void write(Object out) {
		System.out.print(out);
	}

	public static boolean getBool(String prompt) {
		write(prompt);
		boolean result = TextIO.getlnBoolean();	
		write("\n");
		return result;
	}

	public static int getInt(String prompt) {
		write(prompt);
		int result = TextIO.getlnInt();	
		write("\n");
		return result;
	}

	public static char getChar(String prompt) {
		write(prompt);
		char result = TextIO.getlnChar();	
		write("\n");
		return result;
	}


}
