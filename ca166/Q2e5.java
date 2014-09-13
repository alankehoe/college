public class Q2e5{
	static class point{
		private double x,y;
		
		public void getPoint(){
			x = Console.readDouble();
			y = Console.readDouble();
		}
		
		public double Dist(point a){
			return Math.sqrt((a.x-x)*(a.x-x)+(a.y-y)*(a.y-y));
		}
	}
	
	static class circle{
		private point a = new point();
		private double rad;
		
		public void getCircle(){
			a.getPoint();
			rad = Console.readDouble();
		}
		
		public boolean Overlap(circle b){
			if(a.Dist(b.a) < rad + b.rad)
				return true;
			else 
				return false;
		}
	}
	
	public static void main(String [] args){
		circle x = new circle();
		circle y = new circle();
		x.getCircle();
		y.getCircle();
		if(x.Overlap(y))
			System.out.println("they overlap");
		else 
			System.out.println("They dont");
	}
}
			
		
