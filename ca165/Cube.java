public class Cube
{
	static int cubed(int num)
	{
		int result = num*num*num;
		
		return result;
	}
	
	public static void main (String [] args)
	{
		System.out.println("number \t cubed");
		int count = 0;
		for (count=0;count <= 20;count++)
		{
			System.out.println(count + "\t" + cubed(count));
		}
	}
}
