public class Pascal
{
	public static void main(String [] args)
	{
		System.out.println("Enter the nth line of pascal's triangle: ");
		int n = Console.readInt();
		int [] b = { 1, 1};
		for( int i = 0; i <= n; i++)
		{
			int [] a = new int [i+1];
			a[0] = 1;
			a[a.length - 1] = 1;
			if(i == 0)
				System.out.println("1");
			if(i == 1)
				System.out.println("1 1");
			if(i >= 2)
			{
				for(int j = 1; j < a.length - 1; j++)
				{
					a[j] = b[j-1] + b[j]; 
				}
				b = a;
				for( int j = 0; j < b.length; j++)
				{
					System.out.print(b[j] + " ");
				}
				System.out.println("");
			}
		}	
	}
}
