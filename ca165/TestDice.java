public class TestDice
{	
	static int roll(int high, int low) // generate a random number between two parameters
	{
		double random = Math.random()*10;
		int result = (int)random;
		
		while (result > high || result < low)
		{
		random = Math.random()*10;
		result = (int)random;
		}
		
		return result;
	}

	public static void main (String [] args)
	{
		System.out.println("How many times do you want to throw the dice : ");
		int times = Console.readInt();// how many times you want to rool the dice
		int [] dice ={0,0,0,0,0,0};// all values in the array are zero
		//System.out.println(a); 
		
		for (int i = 0; i < times; i++)// controls the amount of times the loop takes place
		{
			int a = roll(5,0);// method for generating a random number
			dice[a]++;//adds to the index at the random number if the index comes up see results	
		}
		System.out.println("1:		"+dice[0]); // print statements
		System.out.println("2:		"+dice[1]);
		System.out.println("3:		"+dice[2]);
		System.out.println("4:		"+dice[3]);
		System.out.println("5:		"+dice[4]);
		System.out.println("6:		"+dice[5]);		
	}
	//some of the results form testing see when zero is entered there are no index hits this shows the program runs properly.
	
	//How many times do you want to throw the dice : 
	//1000
	//1:		178
	//2:		182
	//3:		171
	//4:		161
	//5:		140
	//6:		168
	
	//How many times do you want to throw the dice : 
	//0
	//1:		0
	//2:		0
	//3:		0
	//4:		0
	//5:		0
	//6:		0
	
	//How many times do you want to throw the dice : 
	//6
	//1:		1
	//2:		2
	//3:		1
	//4:		1
	//5:		0
	//6:		1
	
	//How many times do you want to throw the dice : 
	//30000  
	//1:		4922
	//2:		5011
	//3:		5030
	//4:		5125
	//5:		4896
	//6:		5016
}
