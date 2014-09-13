public class Triangletype
{
	public static void main (String [] args)
	
	{
		System.out.println ("enter lenghts");
	
	
	
		int a = Console.readInt();
		int b = Console.readInt();
		int c = Console.readInt();
	
		if ((a + b <= c) || (a + c <= b) || (c + b <= a))
		{
			System.out.println ("triangle is impossible");
		}	
			
		else if ((a == b) && (a == c) && (b == c))
		{
			System.out.println("triangle is equalateral");
		}
		
	
		else if ((a == b) || (a == c) || (c == b))
		{
			System.out.println("triangle is isosceles");
		}
		
		else 
		{
			System.out.println("triangle is ordinary");
		}
	}
	
	
	
}
