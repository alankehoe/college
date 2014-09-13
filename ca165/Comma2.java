public class Comma2
{
	public static void main (String [] args)
	{
      		System.out.print("Please enter a number >= 1000: ");
		String input = Console.readString();
		
		int strLength = input.length();
		
		String result = new String();
		String x = new String();
		String y = new String();
		
		if (strLength == 5) 
		{
			x = input.substring(0, 1);
			y = input.substring(2);
			result = x + y;
		}
		if (strLength == 6) 
		{
			x = input.substring(0, 2);
			y = input.substring(3);
			result = x + y;
		}
		if (strLength == 7) 
		{
			x = input.substring(0, 3);
			y = input.substring(4);
			result = x + y;
		}
		
		System.out.println(result);
	}
}
