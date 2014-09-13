public class Triangle{
	static void TriangleType(int a, int b, int c){
		if(a + b <= c || b + c <= a || a + c <= b)
			System.out.println("Not a triangle ");
		
		else if(a == b && a == c && b == c)
			System.out.println("equalateral ");
		
		else if(a == b || a == c || b == c)
			System.out.println("isoscles");
		else	
			System.out.println("Scalene ");
	}
	
	public static void main(String [] args){
		System.out.println("enter three positive lenghts :");
		int a = Console.readInt();
		int b = Console.readInt();
		int c = Console.readInt();
		TriangleType(a,b,c);
	}
}
	
		
