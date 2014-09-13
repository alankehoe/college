public class ArraySum
{
	public static void main (String [] args)
	{
		int [] alan ={5, 60, 4, 54, 30, 20, 9};
		
		int sum = 0;
		for(int i = 0 ;i < alan.length ; i++)
		{
			sum = sum + alan[i];
		}
		System.out.println(sum);
	}
}
