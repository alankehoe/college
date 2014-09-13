import java.util.Random;
public class RandomDate
{
	public static void main(String [] args)
	{
		Random generator = new Random();
		String [] poo = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
		int month = generator.nextInt(12);
		int day = 0;
		if(month == 0 || month == 2 || month ==  4 || month == 6 || month == 7 || month == 9 || month == 11)
		{
			day = (int)generator.nextInt(31) + 1;
			System.out.println( day + "/" + poo[month]);
		}
		if( month == 3 || month == 5 || month == 8 || month == 10)
		{
			day = (int)generator.nextInt(30) + 1;
			System.out.println( day + "/" + poo[month]);
		}
		if(month == 1)
		{
			day = (int)generator.nextInt(28) + 1;
			System.out.println( day + "/" + poo[month]);
		}
		
		
	}
}
