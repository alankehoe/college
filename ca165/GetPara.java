public class GetPara
{
	static String getFirst(String original, int numChars)
	{
		String result;
		result = original.substring(0, numChars);

		return result;
	}
	public static void main(String [] args)
	{
		// Get first two characters
		String code1 = getFirst("Ireland", 2);
		System.out.println(code1);

		// Get first 3 characters
		String code2 = getFirst("France", 3);
		System.out.println(code2);

		// Get the first character
		String code3 = getFirst("USA", 1);
		System.out.println(code3);
	}
}

