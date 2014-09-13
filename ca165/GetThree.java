public class GetThree
{
	static String getFirstThree(String original)
	{
		String result;
		result = original.substring(0, 3);

		return result;
	}

	public static void main(String [] args)
	{
		String code1 = getFirstThree("Ireland");

		String code2 = getFirstThree("France");

		String code3 = getFirstThree("USA");

		// Now print out the first code and the third.
		System.out.println(code1);
		System.out.println(code3);
	}
}
