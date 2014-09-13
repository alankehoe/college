public class Counter
{
	public static void main(String [] args)
	{
		int result= 0;
		while(!Console.EndOfFile())
		{
			int count = Console.readInt();
			result = result+count;
		}
		System.out.println(result);
	}
}
			
			
		
	
	
