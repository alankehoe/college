public class GetTwo
{
	static String getFirstTwo(String original)
	{
		String result;
		result = original.substring(0, 2);

		return result;
	}

	public static void main(String [] args)
	{
		String code1 = getFirstTwo("Ireland");

		String code2 = getFirstTwo("France");

		String code3 = getFirstTwo("USA");

		// Now print out the first code and the third.
		System.out.println(code1);
		System.out.println(code3);
	}
}
