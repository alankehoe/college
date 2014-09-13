public class LargeSwap
{
	public static void main(String [] args)
	{
		System.out.println("How many elements?");
      		int size = Console.readInt();
		int [] numbers = new int[size];
		System.out.println("Enter " + size + " numbers:");
		int x = 0;
		int j = 0;
     		for(int i = 0; i < numbers.length; i++)
		{
         		numbers[i] = Console.readInt();
			if(numbers [i] > x)
			{
				x = numbers[i];
				j = i;
			}
		}
		System.out.println("a[" + j + "] = " + x + " is the largest");
		int q = numbers[0];
		numbers[0] = numbers[j];
		numbers[j] = q;
		System.out.println("First element: " + numbers [0] + " swapped first : " + numbers[j] );
	


	}
}
