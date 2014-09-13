public class Circle{
	
	static class Circlee{
		double radius;
		
		void getCircle(){
			System.out.println("Enter radius :");
			radius = Console.readDouble();
		}
		
		double Area(){
			return(3.14*(radius*radius));
		}
		
		double Circ(){
			return(2*3.14*radius);
		}
		
		void putCircle(){
			System.out.println("Radius = "+radius+" Area = "+Area()+" Circumference = "+ Circ());
		}
	}
	
	public static void main(String [] args){
		Circlee a = new Circlee();
		a.getCircle();
		a.putCircle();
	}
}
