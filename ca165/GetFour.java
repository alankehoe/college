public class GetFour
{
	static String getFirstFour(String original)
	{
		int strlength = original.length();
		if (strlength > 3)
		{
			String result;
			result = original.substring(0, 4);
			return result;
		}
		else
		{
			return original;
		} 
	}

	public static void main(String [] args)
	{
		String code1 = getFirstFour("Ireland");

		String code2 = getFirstFour("France");

		String code3 = getFirstFour("USA");

		// Now print out the first code and the third.
		System.out.println(code1);
		System.out.println(code3);
	}
}
