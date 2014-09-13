import java.io.*;

public class Q1e9{
	static class course{
		private String a;
		private int b;
		
		public void getCourse(){
			a = Console.readToken();
			b = Console.readInt();
		}
		
		public String putCourse(){
			return a;
		}
		
		public int getInt(){
			return b;
		}
	}
	
	public static void main(String [] args){
		try{
			course [] a = new course[1000];
			int i = 0;
			int b = 0;
			PrintWriter p = new PrintWriter("over30.txt");
			while(!Console.endOfFile()){
				a[i] = new course();
				a[i].getCourse();
				b = b + a[i].getInt();
				if(a[i].getInt()>=30){
					p.printf("%-12s%-5d",a[i].putCourse(),a[i].getInt());
					p.println("");
				}
				i++;
			}
			System.out.println("The average number per course is "+ b/i);
			p.close();
		}
		
		catch(IOException e){
			System.out.println("Problem with file");
		}
	}
}
			
