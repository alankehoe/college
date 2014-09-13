import java.util.Random;

public class HangMan
{
	public static void main(String [] args)
	{	
		Random generator = new Random();
		int word = generator.nextInt(11);
		String[] names ={"computer","aardvark","alkaline","backrest","backroom","cocktail","cocoanut","hardware","software","hardwood","minidisk"};
		String[] hyphens ={"-","-","-","-","-","-","-","-"}; 
		char [] letters = names[0].toCharArray();		
		//System.out.println(names[word]);
		
		for(int i = 0; i < 8; i++)
		{
			System.out.println("Enter a letter :");
			char guess =Console.readChar();
			
			if(letters[i] == guess);
			{
				
			}
					
		}
	}
}
