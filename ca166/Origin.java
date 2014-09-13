public class Origin{
	
	static class Point{
		double x, y; // cooordinates
		
		void getPoint(){
			System.out.println("Enter coordinates :");
			x = Console.readDouble();
			y = Console.readDouble();
		}
		
		void putPoint(){
			System.out.println("(" + x + "," + y + ")");
		}
		
		double distance(){
			return(Math.sqrt(x*x+y*y));
		}
		
		void midPoint(Point p){
			Point mid = new Point();
			mid.x = (x+p.x)/2;
			mid.y = (y+p.y)/2;
			System.out.println("The mid-point of ("+x+","+y+") and ("+p.x+","+p.y+") is ("+mid.x+","+mid.y+")");
		}
	}
	
	public static void main (String [] args){
		Point p = new Point();
		Point x = new Point();
		p.getPoint();
		x.getPoint();
		if(p.distance()>x.distance())
			System.out.println("Point x is closer to the origin.");
		else
			System.out.println("Point p is closer to the origin.");
		p.midPoint(x);
		//System.out.println(p.distance());
	}
}
	
	
	
