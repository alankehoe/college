public class UserMethod
{
	static String getFirst(String original, int numChars)
	{
		String result;
		result = original.substring(0, numChars);

		return result;
	}
	public static void main(String [] args)
	{
		// enter first name
		System.out.println("Enter First name: ");
		String first = Console.readString();
		int strlength = first.length();
		if (strlength <= 6)
		{
		//String code1 = getFirst(first, 6);
		//System.out.println(code1);

		//enter last name
		System.out.println("Enter Last name: ");
		String last = Console.readString();
		String code2 = getFirst(last, 1);
		//System.out.println(code2);
		
		System.out.println("Your username is "+ first + code2 + strlength);
		}
		
		if (strlength >= 6)
		{
		String code1 = getFirst(first, 6);
		//System.out.println(code1);

		//enter last name
		System.out.println("Enter Last name: ");
		String last = Console.readString();
		String code2 = getFirst(last, 1);
		//System.out.println(code2);
		
		System.out.println("Your username is "+ code1 + code2 + strlength);
		}
	}
}

