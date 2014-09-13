public class ArrayFive
{
	public static void main(String [] args)
	{
		int [] five = new int[5];
		
		System.out.println("Enter 5 integers : ");
		
		for(int i = 0; i < 5; i++)
			{
		  	five[i] = Console.readInt();
		  	//System.out.println(five[i]);
			}
		
		for(int i = 4; i >= 0; i--)
		{
   			System.out.print(five[i] + " ");
   		}
   		System.out.println("");
   		for(int i = 0; i <= 4; i++)
   		{
   			System.out.print(five[i] + " ");
   		}

	}
}
