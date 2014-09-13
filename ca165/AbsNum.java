public class AbsNum
{  	
	static int absoluteValue(int num)
	{
		if(num < 0)  // if the number is negative ...
		{
		return -num; // ... change its sign and return
		}
	
		else
		{
		return num; // otherwise ... return the number unchanged
		}
	}
	
	public static void main(String [] args)
	{
		int abs = absoluteValue(-5);
		System.out.println(abs);
	}
}
