public class labThree{
	static class Card{
		String suit = "Hearts";
		int rank = 1;
	}
	
	static class BankAccount{
		String name;
		String number;
		double balance;
	}
	
	static class BankLoan{
		double principle;
		double interestrate;
		int months;
		boolean interesttype;
	}
	
	static class Pair{
		int x = 3; double y;
		Pair (double y0) {y = y0;}
		Pair (int x0, double y0) {x = x0; y = y0;}
	}
	
	public static void main(String [] args){
		Card two = new Card();
		two.suit = "clubs";
		two.rank = 3;
		System.out.println(two);
	}
}
