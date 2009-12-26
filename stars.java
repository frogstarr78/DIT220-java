class stars {

	public void stars(int numberOfStars) {
		for(int i=0; i < numberOfStars; i++) {
			System.out.print("*");
		}
		System.out.println("");
	}		

	public int countChars(String haystack, char needle) {
		int ret = 0;
		for(int i=0; i<haystack.length()-1; i++) {
			if(needle == haystack.charAt(i)) {
				ret++;	
			}
		}
		return ret;	
	}

	public int getSmallest(int first, int second, int third) {
		int ret = first;
		if (first < second && first < third)
			ret = first;
		if (second < first && second < third)
			ret = second;
		if (third < first && third < second)
			ret = third;
		return ret;
	}

	public static void main(String[] args) {
		stars star = new stars();
		for(int i=1; i<11; i++) {
			star.stars(i);	
		}

		System.out.println(star.countChars("hello", 'e'));
		System.out.println(star.countChars("hello", 'l'));
		System.out.println(star.getSmallest(2,-4,6));
	}

}
