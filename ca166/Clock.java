public class Clock{
	static class Time{
		private int hour,min;
		
		public void get(){
			String tmp = Console.readString();
			hour = Integer.parseInt(tmp.substring(0,1));
			min = Integer.parseInt(tmp.substring(2,3));
		}
		
		public boolean gt(Time t){
			if(hour > t.hour)
				return true;
			else if(hour == t.hour && min > t.min)
				return true;
			else
				return false;
		}
	}
	static class Period{
		private Time a,b;
		
		public void get(){
			a = new Time();
			a.get();
			b = new Time();
			b.get();
		}
		
		public boolean overlaps(Period p){
			if(a.hour > p.a.hour && a.hour < p.b.hour)
				return true;
			else if(b.hour > p.a.hour && b.hour < p.b.hour)
				return true;
			else if(p.a.hour > a.hour && p.a.hour < b.hour)
				return true;
			else if(p.b.hour > a.hour && p.b.hour < b.hour)
				return true;
			else 
				return false;
		}
	}
	public static void main(String [] args){
		Period a = new Period();
		Period b = new Period();
		a.get();
		b.get();
		if(a.overlaps(b))
			System.out.println("good");
	}
}
