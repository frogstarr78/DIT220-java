import java.util.Arrays;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class HighLowRandom extends Randomer {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Tue Oct 17 21:22:54 PDT 2006
	Chapter 4
*/

	public HighLowRandom(int howMany) {
		super(howMany);
		randoms = new int[numberOfRandoms];

		write("Random numbers are: ");
		for(int i=0; i<numberOfRandoms; i++) {
			randoms[i] = getNewRandomInteger();
			write(randoms[i]);
			write(" ");
		}
		write("\n");

		Arrays.sort(randoms);
	}

	public int getLowest() { return randoms[0]; }
	public int getHighest() { return randoms[numberOfRandoms-1]; }

	public static void main(String[] args) {
		boolean userWantsToContinue = false;
		int numberOfRandoms;

		do {
			numberOfRandoms = getInt("How many numbers would you like to generate? ");
			HighLowRandom highLowRand = new HighLowRandom(numberOfRandoms);

			int high = highLowRand.getHighest();
			int low  = highLowRand.getLowest();
			write("Of the [" + highLowRand.numberOfRandoms + "] randomly generated numbers, ");
			write("\n" + high + " is the highest;");
			write("\nand " + low + " is the lowest;\n");
			boolean writeNotUniqueMessage = false;
			if(highLowRand.numberOfRandoms == 100 && low != 0) writeNotUniqueMessage = true;
			if(highLowRand.numberOfRandoms == 100 && high != 100) writeNotUniqueMessage = true;

			if(writeNotUniqueMessage) write("I didn't say 'unique' random. :-)\n");
			
			userWantsToContinue = getBool("Continue HighLowRandom output? (yn): ");
		} while(userWantsToContinue);
	}
}
