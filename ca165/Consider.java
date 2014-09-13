public class Consider
{
	public static void main(String [] args)
	{
		int y = 0;
		int count = 0;

		int [] a = { 12, 4, 11, 15, 0, 19, 6, 7, 8, 10};

		for(int i = 1; i < a.length; i = i + 1)
   		if(a[i] > a[i-1])
   		{
      		count++;
  		}
  		System.out.println(count);
	}
}
