public class Question2
{
	public static void main(String [] args)
	{
		System.out.println("How many words :");
		int j =Console.readInt();
		System.out.println("Enter a String :");
		String [] line =new String [j];
		String [] result =new String [j];
		int k = 0;
		
		for(int i = 0; i < line.length; i++)
		{
			line[i]=Console.readString();
			if(line[i].charAt(0)==('{'))
			{
				result[k]=line[i];
				k++;
			}
		}
		System.out.println("The tags were :");
		while(results[k].charAt(0)==('{'))
		{
			System.out.println(results[k]);
			k++;
		}
	}
}
