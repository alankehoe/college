public class Arrays21
{
	public static void main(String [] args)
	{
		int a [] = new int [10];
		for(int x = 0; x < a.length; x++)
		{
			a [x] = x + 1;
			System.out.println(a [x]);
		}

		int b [] = new int [11];
		for(int x = 0; x < b.length; x++)
		{
				b[x] = x * 2;
				System.out.println(b [x]);
		}
		int c [] = new int [10];
		for(int x = 1; x <= 10; x++)
		{
			c[x-1] = x * x;
			System.out.println(c[x-1]);
		}
		int d [] = new int [10];
		for(int x = 0; x < 10; x++)
		{
			System.out.println(d[x]);
		}
		int [] e = { 1, 4, 9, 16, 9, 7, 4, 9, 11};
		for(int x = 0; x < e.length; x++)
		{
			System.out.println(e[x]);
		}
	}
}
