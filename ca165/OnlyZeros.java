public class OnlyZeros
{
	public static void main(String [] args)
	{
		int a [] = {0,0,0,0,0,0,0,1,0,0,0};
		int count = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == 0)
				count++;				
		}
		
		if(count == a.length)
			System.out.println("only zeros");
		else
			System.out.println("not only zeros");
	}
}
