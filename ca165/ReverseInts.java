public class ReverseInts
{
	static boolean palin(int a [])
	{
		for(int i = 0; i < a.length/2; i++)
		{
			if(i != a.length -1 -i)
				return false;
		}
		return true;
	}
	
	public static void main(String [] args)
	{
		System.out.println("How many in the array :");
		int amount = Console.readInt();
		int [] total = new int[amount];
		
		System.out.println("Enter "+ amount + " integers : ");
		for(int i = 0; i < total.length; i++)
			{
		  	total[i] = Console.readInt();
			}
				
		boolean x = palin(total);
		System.out.println(x);
	}
}
