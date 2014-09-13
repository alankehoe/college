public class Time{
	static class clock{
		int hour,min;
		
		public void getTime(){
			System.out.println("Enter the time :");
			hour = Console.readInt();
			min = Console.readInt();
		}
		
		public void tick(){
			clock after = new clock();
			if(min == 59){
				after.min = 0;
				after.hour = hour+1;
			}
			else{
				after.min = min+1;
				after.hour = hour;
			}
			after.putTime();
			System.out.println("");
		}
		
		private void putHour(){
			if(hour < 10 )
				System.out.print("0"+hour+":");
			else
				System.out.print(hour+":");
		}
		
		private void putMin(){
			if(min < 10)
				System.out.print("0"+min);
			else
				System.out.print(min);
		}
		
		public void putTime(){
			putHour();
			putMin();
		}
	}
	
	public static void main(String [] args){
		clock a = new clock();
		a.getTime();
		System.out.print("One minute after ");
		a.putTime();
		System.out.print(" is ");
		a.tick();
	}
		
}
			
			
