public class Date
{
	static String dayName(int n){
		String [] daysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		String day = daysOfWeek[n];
		return day;
	}

	static int firstDay(int y){
		return (((y-1900)*365 + (y-1901)/4 + 1)% 7);    
	}
	
	static int daysInMonth(int m, int y){
		if (m==9 || m==4 || m==6 || m==11)  
			return(30);
		else if (m==2){
			if (y%4==0 && y!=1900) 
				return(29);
	   	   	else 
	   	   		return(28);
		}
		else 
			return(31);
	}

	static int dayOfWeek(int d, int m ,int y){
		int count = 0;
		int day = firstDay(y);
		for(int i = 1; i < m; i++){
			count = count + daysInMonth(i, y);
		}
		count=count + d - 1;
		return (count + day) % 7;
	}

	public static void main(String [] args){
		System.out.println("Enter a date:");
		int d = Console.readInt();
		int m = Console.readInt();
		int y = Console.readInt();
		int x = dayOfWeek(d, m, y);
		System.out.println(dayName(x));
	}
		
}