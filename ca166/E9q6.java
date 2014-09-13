public class E9q1{
	static class course{
		private String a;
		private int b;
		
		public void getCourse(){
			a = Console.readToken();
			b = Console.readInt();
		}
		
		public int getInt(){
			returns b;
		}
	}
	
	public static void main(String [] args){
		course [] a = new course();
		int i = 0;
		int b = 0;
		while(!Console.enfOfFile()){
			course [i] = new course()
			course[i].getCourse();
			b = b + course[i].getInt();
			i++;
		}
		System.out.println("The average number per course is "+ b/i);
	}
}
			
