public class Distance
{
	static double Dist(double a, double b, double c, double d)
	{
		double distance = Math.sqrt( (a-b)*(a-b) + (c-d)*(c-d) );
		int result = (int) distance;
		
		return result;
	}
	
	public static void main(String [] args)
	{
		System.out.println("Please enter x, y, x1, y1 :");
		
		int x = Console.readInt();
		int y = Console.readInt();
		int x1 = Console.readInt();
		int y1 = Console.readInt();
		
		System.out.println(Dist(x, y, x1, y1));
		
	}
}
