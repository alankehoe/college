public class Strings
{
	public static void main (String [] args)
	{
      		String name = "albert einstein";

      		String x = name.substring(2, 6);
     		String y = name.substring(8, 9);
		String z = name.substring(7, 8);
		
		String newName = x+y+z;
		System.out.println(newName);
		
	}
}
