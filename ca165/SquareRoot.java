public class SquareRoot
{
	static double root(double num)
	{
		double x = Math.sqrt(num);
		
		return x;
	}
	
	public static void main (String [] args)
	{
		int count = 0;
		
		System.out.println("N \tRoot");
		for (count = 0;count <= 20;count++ )
		{
			System.out.println(count + "\t" + root(count));
		}
	}
}
