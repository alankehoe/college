public class PowerOf
{
	static int power(int a,int b)
	{
		int result = a^b;
		
		return result;
	}
	
	public static void main(String [] args)
	{
		int original = 2;
		int powerof = 0;
		System.out.println("");
		
		for(powerof=0; powerof<=20; powerof++)
		{
			System.out.println("2 to the power of "+ powerof +" = "+ Math.pow(original, powerof));
		}
		System.out.println("\nEnd of Program\n"); 
	}
}
