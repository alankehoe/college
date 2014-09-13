public class User
{
	public static void main (String [] args)
	{
      		System.out.print("Please enter your First Name: ");
		String x = Console.readString();
		String fName = x.substring(0, 1);
		
		System.out.print("Please enter your Surname: ");
		String sName = Console.readString();

		System.out.print("Please enter a number: ");
		String num = Console.readString();
		
		String uName = fName+sName+num;
		System.out.println("Your Username is " + uName);

	}
}
