public class CountThree
{
	public static void main(String [] args)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		System.out.println("Enter a sequence of numbers (-9 to end): ");
		while (i != -9)
		{
		   i = Console.readInt();
		   if (i == -9)
			break;
		   else
		   if (i%3 == 0)
			k = k + 1; 
		   j = j + 1;
		}
		System.out.println("There were " + j + " numbers.");
		System.out.println( k + " numbers were divisible by 3");		   
	}
}
