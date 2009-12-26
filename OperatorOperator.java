public class OperatorOperator {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Sun Oct  8 23:56:54 PDT 2006
	Chapter 3 Program 3
*/

	public static boolean run () {
		double val1, val2;
		char op;
		double result = 0.0;
		boolean errored = false;
		char retry = 'Y';

		System.out.println("Please enter an expression to be evaluated.");
		System.out.println("e.g. 4.0+5, 3-5, etc.");
		System.out.println("Not: N/0.");
		System.out.print(" Equation: ");
		val1 = TextIO.getDouble();
		op = TextIO.getChar();
		val2 = TextIO.getlnDouble();
		System.out.println("");

		if (val2 == 0.0 && op == '/') {
			System.out.println(" Sorry 0 cannot be a value for the denominator of your equation.");
			System.out.print(" Please specify a different value: ");
			val2 = TextIO.getlnDouble();
			System.out.println("");
		}

		switch (op) {
			case '*':
				result = val1*val2;
				break;
			case '/':
				result = val1/val2;
				break;
			case '+':
				result = val1+val2;
				break;
			case '-':
				result = val1-val2;
				break;
			case '%':
				result = val1%val2;
				break;
			default:
				errored = true;
				break;
		}

		if(errored)
			System.out.println("Operator must be %*/-+ received [ " + op + "].");
		else 
			System.out.println(val1 + " " + op + " " + val2 + " = " + result);

		System.out.print("Continue?[Yn]: ");
		retry = TextIO.getlnChar();
		System.out.println("");
		if (retry == 'Y' || retry == 'y') {
			return true;
		} else if (retry == 'n' || retry == 'N') {
			return false;
		} else {
			return false;
		}
	}

	public static void main (String[] args) {
		boolean doRun;
		do {
			doRun = run();
		} while (doRun == true);
		System.out.println("Thank you for using OperatorOperator");
	}

}
