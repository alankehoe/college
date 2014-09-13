public class Encrypter
{
	
	public static void main(String [] args)
	{
		String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String message = Console.readString();
		int x = 0;
		
		for(int i = 0; i < message.length(); i++)
		{
			if(alphabet[i] == message.charAt(x))
			{
				message.charAt(x)=alphabet[i+4];
			}
			x++;
		}
		System.out.println(message);
			
	}
}
