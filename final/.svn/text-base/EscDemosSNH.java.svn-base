/*
	DIT220 Java 
	Scott Noel-Hemming
	Wed Dec  6 10:32:04 PST 2006
	Final Answer #23
*/

class EscDemosSNH_Q23 {
	public static void main (String[] args) {
		int nums[] = new int[4];
		System.out.println("Before exception is generated.");

		try {
			nums[7] = 10;
			System.out.println("This won't be displayed due to exception.");
		} catch(ArrayIndexOutOfBoundsException exc) {
			System.out.println(exc.toString());
			System.out.println("Index out-of-bounds!");
		} finally {
			System.out.println("This line of code will run regardless of the exception situation. Have a good year!");
		}
		System.out.println("After catch statment.");
	}
}
