public class Q1e5{
	static class Date{
		private int day,month,year;
		
		public boolean Before(Date a){
			if(year < a.year)
				return true;
			if(year == a.year && month < a.month)
				return true;
			if(year == a.year && month == a.month && day < a.day)
				return true;
			else 
				return false;
		}
		
		public void getDate(){
			day = Console.readInt();
			month = Console.readInt();
			year = Console.readInt();
		}
		
		public void putDate(){
			System.out.printf("%02d/%02d/%02d\n", day, month, year);
		}
			
	}
	
	private static void sort(Date [] ds, int n){
		Date tmp = new Date();
		for(int j = 0; j < n-1;j++){
			for(int i = 0;i < n-1;i++){
				if(!ds[i].Before(ds[i+1])){
					tmp = ds[i];
					ds[i] = ds[i+1];
					ds[i+1] = tmp;
				}
			}
		}
	}
					
	
	public static void main(String [] args){
		Date [] a = new Date [1000];
		int count = 0;
		while(!Console.endOfFile()){
			a[count] = new Date();
			a[count].getDate();
			count++;
		}
		sort(a,count);
		System.out.println("");
		for(int i = 0; i < count; i++){
			a[i].putDate();
		}
	}
}
