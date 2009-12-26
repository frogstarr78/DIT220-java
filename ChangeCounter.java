public class ChangeCounter {

	/**
	 * @param args
	 */
	public static void dump(String out) {
		System.out.println(out);
	}

	public static int askAndTell(String what){
		int ret;

		String string = "How many ";
		if(what == "penny") {
			string += "pennies";
		} else {
			string += what + "s";
		}
		System.out.print(string + " do you have? ");
		ret = TextIO.getlnInt();
		
		string = "You have " + ret + " " + what;
		if (ret > 1){
			if(what == "penny") {
				string += "ies";
			} else {
				string += "s";
			}
		}
		System.out.println(string);
		return ret;
	}

	public ChangeCounter() {}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int quarters, dimes, nickles, pennies;
		
		quarters = askAndTell("quarter");
		dimes = askAndTell("dime");
		nickles = askAndTell("nickle");
		pennies = askAndTell("penny");
		
		int dollars = (quarters*25) + (dimes*10) + (nickles*5) + pennies;
		String string = "You've got "; 
		if(dollars >= 100){
			string += (dollars/100) + " dollar" + ((dollars/100) > 1 ? "s" : "") + " and ";
		}
		
		if((dollars % 100) > 0) {
			string += (dollars % 100) + " cents";
		}
		string += " or $" + (dollars/100) + "." + ((dollars%100) < 10 ? "0" + dollars%100 : dollars%100);
		dump(string);
	}

}
