public class GetFive
{
	public static void main(String [] args)
	{
		System.out.println("How many elements?");
      		int size = Console.readInt();
		int [] numbers = new int[size];
		System.out.print("Enter " + size + " numbers:");
		int j = 0;
     		for(int i = 0; i < numbers.length; i++)
		{
         		numbers[i] = Console.readInt();
			if(numbers [i] == 5)
				j++;
		}
		int k [] = new int [j];
		j = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			if(numbers [i] == 5)
			{
				k[j] = i;
				j++;
			}
		}
		System.out.println("The indices of 5 are: " );
		for(int i = 0; i < k.length; i++)
		{
			System.out.print( k[i] + " " );
		}
	}
}
