public class RandomDigits
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
		System.out.println("How many Random numbers : ");
		int amount = Console.readInt();
		System.out.println("numbers between 1 and :");
		int range =Console.readInt();
		int [] dice = new int[range + 1];
				
		for (int i = 1; i <= amount; i++)
		{
			int a = roll(range,1);
			dice[a]++;	
		}		
		
		for (int a = 1;a <= range; a++)
		{
			System.out.println(a+":		"+dice[a]);
		}
	}
}
