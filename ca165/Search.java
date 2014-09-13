public class Search
{
	static boolean search(int [] numbers, int value)
	{
		for (int i = 0; i< numbers.length; i++)
		{
			if(numbers[i] == value)				
				return true;
		}
			return false;
	}
	
	public static void main (String [] args)
	{
		int [] scores = { 20, 15, 13, 7, 25, 10 };
		boolean contains7 = search(scores, 7);
		System.out.println(contains7);
		
		boolean contains25 = search(scores, 25);
		System.out.println(contains25);
		
		boolean contains0 = search(scores, 0);
		System.out.println(contains0);
	}

}
