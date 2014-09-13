public class Date 
{
	public static void main (String [] args)
	{
		
		
		System.out.print("enter day :");
		int day = Console.readInt();
		System.out.print("enter month :");
		int month = Console.readInt();
	
		if ( (month >=3) && (month <= 6) )
		{
			System.out.println("second quater of the year");
		}
		
		else 
		{
			System.out.println("not second quater");
		}
		
		if ( (month == 2) && (day >= 28) )
		{
			System.out.println ("last day of the month");
		}
		
		else if ( (month == 1) && (day >= 31) || (month >= 3) && (month <= 12) && (day >= 31) )
		{
			System.out.println("last day of month");
		}
		
		else 
		{
			System.out.println("not last day of the month");
		}
		
		if ( (month <= 4) )
		{
			if((month==4)&& (day <= 15))
			{
			System.out.println("before april 15th");
			} 
		}

		
	}
	
}
