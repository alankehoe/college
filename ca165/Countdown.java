public class Countdown
{	
	public static void main(String [] args)
	{
		//System.out.println("Enter a number :");
		int a = Console.readInt();
		System.out.println("How many seconds:");
		System.out.println(a);
			
		while(a > 0)
		{		
			a--;
			System.out.println(a);
		}
		System.out.println("We have lift off!");
	}
}
