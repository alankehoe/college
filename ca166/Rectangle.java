public class Rectangle{
	
	static class rectangle{
		int length, height;
		
		void get(){
			System.out.println("Enter Lenght and Height :");
			length = Console.readInt();
			height = Console.readInt();
		}
		
		boolean largerThan(rectangle r){
			return length * height > r.length * r.height;
		}
	}
	
	public static void main(String [] args){
		rectangle a = new rectangle();
		rectangle b = new rectangle();
		a.get();
		b.get();
		if(a.largerThan(b))
			System.out.println("First rectangle is larger :");
		else 
			System.out.println("Second rectangle is larger");
	}
}
