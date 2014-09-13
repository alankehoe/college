public class School{
	static class student{
		private int mark;
		private String name,surname;
		
		public void getStudent(){
			System.out.println("Enter details :");
			mark = Console.readInt();
			name = Console.readToken();
			surname = Console.readToken();
		}
		
		public void putStudent(){
			System.out.println(surname+", "+name);
		}
		
		public boolean betterThan(student tmp){
			if(mark > tmp.mark)
				return true;
			else
				return false;
		}
	}
	
	public static void main(String [] args){
		student [] clas = new student [1000];
		student best = new student();
		clas[0] = new student();
		clas[0].getStudent();
		int count = 1;
		while(!Console.EndOfFile()){
			clas[count] = new student();
			clas[count].getStudent();
			if(clas[count].betterThan(clas[count-1]))
				best = clas[count];
			count++;
		}
		best.putStudent();
	}
}
			
			
