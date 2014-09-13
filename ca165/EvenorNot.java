public class EvenorNot
{
	static boolean isEven(int num)
	{	
		return (num % 2 == 0);
	}
	
	  	

	public static void main(String [] args)
	{
		for(int count = 1; count <= 20; count = count + 1)
		{
			if(isEven(count))
			{
      			System.out.println(count + " is even");
      			}
			else
			{
      			System.out.println(count + " is odd");
      			}
		}
	}
}
