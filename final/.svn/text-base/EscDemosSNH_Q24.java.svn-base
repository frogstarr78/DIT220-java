/*
	DIT220 Java 
	Scott Noel-Hemming
	Wed Dec  6 10:32:04 PST 2006
	Final Answer #24
*/

class EscDemosSNH_Q24 {

	public static void insert(int[] array, int index, int value){
		array[index] = value;	
	}
	public static void add(int[] array, int value) {
		for(int i=0; i<array.length; i++){
			if (array[i] == 0 && value != 0) {
				array[i] = value;
			}
		}
	}
	public static void show(int[] array) {
		for(int i=0; i<array.length; i++){
			System.out.println("array[" + i + "] = " + array[i] + ";");
		}
	}

	public static int sum(int[] array) {
		int result = 0;
		for(int i=0; i<array.length; i++){
			result += array[i];	
		}	
		return result;
	}
	public static int avg(int[] array) {
		return sum(array)/array.length;
	}

	public static void main (String[] args) {
		int nums[] = new int[5];
		System.out.println("Before exception is generated.");


		try {
			for(int i=0; i<nums.length; i++) {
				System.out.println(i);
				insert(nums, ((nums.length-1)-i), i);
			}
			show(nums);
			System.out.println("Array Sum: " + sum(nums));
			System.out.println("Array Average: " + avg(nums));
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
