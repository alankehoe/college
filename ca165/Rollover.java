public class Rollover
{
	public static void main(String [] args)
	{
		int count = 10;
				
		while (count > 0 )
		{
			count --;
			System.out.print("there were " + count );
			System.out.print(" in the bed and the little one said roll over roll over ");
			System.out.println("they all rolled over and one fell out");
			
			if (count == 0)
			{
			System.out.println("the little one said alone at last");
			}
		}
	}
}
