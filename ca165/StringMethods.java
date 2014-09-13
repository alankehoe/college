public class StringMethods
{
	public static void main(String [] args)
	{
		String a = new String();
		System.out.println("Enter a string in lower case : ");
		a =Console.readString();
		String b = new String();
		int i = 0;
		i = a.indexOf("hello");
		System.out.println("This string in higher case looks like : ");
		b = a.toUpperCase();
		b = b.concat("    By Alan kehoe !!! "+" the word \"hello\" starts at index "+i);
		System.out.println(b);	
	}
}
