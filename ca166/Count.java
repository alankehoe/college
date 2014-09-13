public class Count
{
	public static void main(String [] args)
	{
		int numL = 0;
		String s = Console.readString();
		while(s != null)
		{
			numL ++;
			s =Console.readString();
		}
		System.out.println(numL+" lines");
	}
}
