public class Area{
	
	static double circle(double a){
		return 3.14 * (a * a);
	}
	
	static double triangle(double a,double b,double c){
		double x = (a + b + c) / 2;
		return Math.sqrt(x*(x-a)*(x-b)*(x-c));
	}
		
	static double rectangle(double a,double b){
		return a * b;
	}
	
	public static void main(String [] args){
		System.out.println("Enter figure and dimensions please:");
		String type = Console.readToken();
		if(type.equals("circle")){
			double a = Console.readDouble();
			System.out.println("Area is : " + circle(a));
		}
		
		if(type.equals("triangle")){
			double a = Console.readDouble();
			double b = Console.readDouble();
			double c = Console.readDouble();
			System.out.println("Area is : " + triangle(a,b,c));
		}
		
		if(type.equals("rectangle")){
			double a = Console.readDouble();
			double b = Console.readDouble();
			System.out.println("Area is : " + rectangle(a,b));
		}
	}
}
			
		
		
