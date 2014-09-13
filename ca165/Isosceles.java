public class Isosceles
{
	public static void main (String [] args)
	{
		System.out.println ("enter lenghts");
	
	
	
		int a = Console.readInt();
		int b = Console.readInt();
		int c = Console.readInt();
	
		
		if ((a == b) || (a == c) || (c == b))
		{
			System.out.println("triangle is isosceles");
		}
		else 
		{
			System.out.print("not isosceles");
		}
	}
}
