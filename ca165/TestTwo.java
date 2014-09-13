public class TestTwo
{
	public static void main(String [] args)
	{
		System.out.println("Enter the words :");
		String w1 = Console.readString();
		String w2 = Console.readString();
		
		String result = "";
		
		for(int i = 0; i < w1.length(); i++)
		{
			boolean found = false;
			for(int j = 0; j < w2.length(); j++)
			{
				if(w1.charAt(i) == w2.charAt(j))
					found = true;
			}
			
			if(!found)
				result += w2.charAt(i);
		}
		System.out.println(result);
	}
}
