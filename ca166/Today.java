import java.util.*;

public class Today{
	static class Date{
		private int day,month,year;
		
		public void getDate(){
			System.out.println("Enter the date (D/M/Y) :");
			day = Console.readInt();
			month = Console.readInt();
			year = Console.readInt();
		}
		
		public void putDate(){
			System.out.println(day+"/"+month+"/"+year+".");
		}
		
		private int numDays(){
			if(month == 1)
				return (day);
			else if(month == 2)
				return (31 +day);
			else if(month == 3)
				return (31 + 28 +day);
			else if(month == 4)
				return (31 + 28 + 31 +day);
			else if(month == 5)
				return (31 + 28 + 31 + 30 +day);
			else if(month == 6)
				return (31 + 28 + 31 + 30 + 31 +day);
			else if(month == 7)
				return (31 + 28 + 31 + 30 + 31 + 30 +day);
			else if(month == 8)
				return (31 + 28 + 31 + 30 + 31 + 30 + 31 +day);
			else if(month == 9)
				return (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 +day);
			else if(month == 10)
				return (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 +day);
			else if(month == 11)
				return (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 +day);
			else	
				return (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 +day);
		}
		
		public boolean before(Date t){
			if(year >= t.year && numDays() > t.numDays())
				return true;
			else 
				return false;
		}
		
		public void thisDay(){
			// return today’s date
			GregorianCalendar c = new GregorianCalendar();	
			day = c.get(Calendar.DATE);
			month  = c.get(Calendar.MONTH)+1;
			year  = c.get(Calendar.YEAR);
		}
	}

		
	public static void main(String [] args){
		Date d = new Date();
		Date today = new Date();
		d.getDate();
		today.thisDay();
		if(today.numDays() == d.numDays())
			System.out.println("Present");
		else if(today.before(d))
			System.out.println("Past");
		else
			System.out.println("Future");
		//System.out.println("today is :"+today.numDays()); just for testing.
		//System.out.println("that date is :"+d.numDays());
	}
		
}
