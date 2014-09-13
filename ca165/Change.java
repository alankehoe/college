public class Change
{
	public static void main (String [] args)
	{
		System.out.println("enter change >= 99");
		
		int change;
		int once;
		int twice;
		int three;
		int four;
		int five;
		int six;
		int leftone;
		int lefttwo;
		int leftthree;
		int leftfour;
		int leftfive;
		int leftsix;
		
		// left followed by a number example leftone stands for leftovers of
		// first division and lefttwo for leftovers of second division and so on
		
		change = Console.readInt();
		System.out.println ("amount of change =");
		
		once = change / 50;
		leftone = change % 50;
		System.out.print ("fifty :");
		System.out.println(once);
		
		twice = leftone / 20;
		lefttwo = leftone % 20;
		System.out.print ("twenty :");
		System.out.println (twice);
		
		three = lefttwo / 10;
		leftthree = lefttwo % 10;
		System.out.print ("ten :");
		System.out.println (three);
		
		four = leftthree / 5;
		leftfour = leftthree % 5;
		System.out.print ("five :");
		System.out.println (four);
		
		five = leftfour / 2;
		leftfive = leftfour % 2;
		System.out.print ("two :");
		System.out.println (five);
		
		six = leftfive / 1;
		leftsix = leftfive % 1;
		System.out.print ("one :");
		System.out.println (six);	
	}
}
