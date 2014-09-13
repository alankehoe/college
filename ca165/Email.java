public class Email
{
	public static void main (String [] args)
	{
      		System.out.print("Please enter your First Name: ");
		String fName = Console.readString();
		
		System.out.print("Please enter your Surname: ");
		String sName = Console.readString();

		System.out.print("Please enter a number: ");
		String num = Console.readString();
		
		String address = "@mail.dcu.ie";
		String email = fName + "." + sName + num + address;
		System.out.println("Your eMail is " + email);

	}
}
