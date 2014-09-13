// *Important* this program does not actually work at all really it only works if you enter ther first too words in the english string to be converted in that order and it will convert it to the first to words in the string arrary pirate. i said i might aswell submit this as i might get some marks instead of none.. appoligies for the shitty program ;)...
public class PirateTalk
{
	public static void main(String [] args)
	{
		String [] english ={"hello","hi","pardon me","excuse me","my","friend","sir","madam","miss","stranger","where","is","the","you","tell","know","how far","old","attractive","happy","nearby","restroom","restaurant","hotel","pub","bank"};
		
		String [] pirate ={"ahoy","yo-ho-ho","avast","arrr","me","me bucko","matey","proud beauty","comely wench","scurvy dog","whar","be","th'","ye","be tellin","be knowin","how many leagues","barnacle-covered","comely","grog-filled","broadside","head","galley","fleabag inn","skull & scuppers","burried treasure"};
		
		System.out.println("How many words to translate :");
		int amount =Console.readInt();
		String [] word = new String [amount];
		System.out.println("Enter a note in english :");                      
		for(int i = 0; i < word.length; i++)
		{
			word[i] = Console.readToken();
			if(word[i].equals(english[i]))
			{
				word[i]=pirate[i];
			}		
		}
		System.out.println("Your not in blackbeard launguage is :");
		for(int i = 0; i < word.length; i++)
		{
			System.out.print(" "+word[i]);
		}
		System.out.println("");
        }
}
