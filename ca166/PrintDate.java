import java.util.*;

public class PrintDate{
	static class Date {
		int day, month, year;
	}
	
	static Date thisDay() {
	// return today’s date
		Date today = new Date();
		GregorianCalendar c = new GregorianCalendar();	
		today.day = c.get(Calendar.DATE);
		today.month  = c.get(Calendar.MONTH)+1;
		today.year  = c.get(Calendar.YEAR);
		return today;
	}
	
	static String monthName(int m) {
	// return the name of month m where 1<=m<=12
		if (m==1) return "January";
		else if (m==2) return "February";
		else if (m==3) return "March";
		else if (m==4) return "April";
		else if (m==5) return "May";
		else if (m==6) return "June";
		else if (m==7) return "July";
		else if (m==8) return "August";
		else if (m==9) return "September";
		else if (m==10) return "October";
		else if (m==11) return "November";
		else return "December";
	}
	
	public static void main(String[] args) {
		// Print today’s date in form typified by 17 January 2011
		Date today = new Date();
		today = thisDay();
		System.out.println(today.day +" "+ monthName(today.month) +" "+ today.year);
	}
}
