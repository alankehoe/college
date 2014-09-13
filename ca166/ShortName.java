public class ShortName{
	public static void main(String [] args){
		System.out.println("Enter your name :");
		String name = Console.readString();
		name = name.trim();
		int i = name.length()-1;
		while(name.charAt(i)!=' ')
			i = i--;
		String surname = (name.substring(i+1));
		surname.toUpperCase();
		char first = name.charAt(0);
		System.out.println(surname + " ," + first);
	}
}
