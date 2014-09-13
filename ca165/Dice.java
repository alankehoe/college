public class Dice
{
	static int roll(int high, int low)
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
	
	public static void main(String [] args)
	{
		for(int i = 1; i <= 20; i++)
		{
      		System.out.println("Throw " + i + ": value is " + roll(6, 1));
		}

	} 
}
