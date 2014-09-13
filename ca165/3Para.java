public class 3Para
{
	static int average(int a, int b, int c)
	{
		double avg = (double) a + (double) b + (double) c;
		double three = avg / 3;
		
		return three;	
	}
	
	public static void main(String [] args)
	{
		System.out.println("The average is" + average(1, 4, 7));	
	}
}
