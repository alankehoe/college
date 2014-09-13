public class Name
{
	public static void main (String [] args)
	{	
		System.out.println("Enter your name: ");
		String input =Console.readString();
		
		int strlength =input.length();

		if(strlength < 4)
		{
			System.out.println("short");
		}
	
		else if(strlength > 7)
		{
			System.out.println("long");
		}
	
		else
		{
			System.out.println("average");
		}	
	}
}
