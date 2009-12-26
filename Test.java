import java.util.*;

class Test {

	// Removes the 4-letter words from c
	static void expurgate(Collection<?> c) {
//		for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
//			if (i.next().length() == 4) {
//				i.remove();
//			}
//		}

		for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
	}


//	static <String> dump() {
//		return "Hello?";	
//	}
// doesn't work.

	public static void main(String[] args) {
		ArrayList coll = new ArrayList();

		coll.add("The");
		coll.add("ocean");
		coll.add("belonged");
		coll.add("to");
		coll.add("them");
		coll.add("and");
		coll.add("they");
		coll.add("sang");

		expurgate(coll);
	}

}
