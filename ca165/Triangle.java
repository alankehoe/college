public class Triangle
{
	public static void main (String [] args)
	{
		int a;
		int b;
		int c;
	
		System.out.println ("please enter lenght : a");
		a = Console.readInt();
		System.out.println ("please enter lenght : b");
		b = Console.readInt();
		System.out.println ("please enter lenght : c");
		c = Console.readInt();
	
		if ( ( a == b ) && ( a == c ) && ( b == c) )
		{
			System.out.println ("Triangle is equalateral");
		}
		
		else if ( ( a == b ) || ( a == c ) || ( b == c ) )
		{
			System.out.println("Triangle is isosceles");
		}
		
		else if ( ( a != b ) || ( a != c ) || ( b != c ) )
		{
			System.out.println ("Triangle is ordinary");
		}
	}
}
