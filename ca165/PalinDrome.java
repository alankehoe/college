public class PalinDrome
{
	static boolean palin(String a)
	{
		for(int i = 0; i < a.length()/2; i++)
		{
			if(a.charAt(i) != a.charAt(a.length() -1 -i))
				return false;
		}
		return true;
	}
	
	public static void main(String [] args)
	{
		System.out.println("Enter a String :");
		String code = Console.readString();
				
		boolean x = palin(code);
		System.out.println(x);
	}
}
