public class Histogram{
	public static void main(String [] args){
		System.out.println("Please enter a sequence of numbers > 0 & < 100 and press CTRL + D to end :");
		String [] store = new String [10];
		for(int i = 0; i < store.length; i++)
			store[i] = "";
			
		while(!Console.EndOfFile()){
			int num = Console.readInt();
			if(num >= 0 && num < 10)
				store[0] = store[0]+"* ";
			else if(num >= 10 && num < 20)
				store[1] = store[1]+"* ";
			else if(num >= 20 && num < 30)
				store[2] = store[2]+"* ";
			else if(num >= 30 && num < 40)
				store[3] = store[3]+"* ";
			else if(num >= 40 && num < 50)
				store[4] = store[4]+"* ";
			else if(num >= 50 && num < 60)
				store[5] = store[5]+"* ";
			else if(num >= 60 && num < 70)
				store[6] = store[6]+"* ";
			else if(num >= 70 && num < 80)
				store[7] = store[7]+"* ";
			else if(num >= 80 && num < 90)
				store[8] = store[8]+"* ";
			else if(num >= 90 && num < 100)
				store[9] = store[9]+"* ";
		}
		System.out.println(" 0- 9: "+store[0]);
		System.out.println("10-19: "+store[1]);
		System.out.println("20-29: "+store[2]);
		System.out.println("30-39: "+store[3]);
		System.out.println("40-49: "+store[4]);
		System.out.println("50-59: "+store[5]);
		System.out.println("60-69: "+store[6]);
		System.out.println("70-79: "+store[7]);
		System.out.println("80-89: "+store[8]);
		System.out.println("90-99: "+store[9]);
	}
}
			
