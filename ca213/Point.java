interface Order{
	boolean lte (Object obj); // Object for max generality // is this object less than or equal to obj?
}

class Point{
	private double x, y; // coordinates
	
	void get() {
		x = Console.readDouble();
		y = Console.readDouble();
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	double distance(Point r) { // distance from r
		double xdist = x-r.x; double ydist = y-r.y;
		return(Math.sqrt(xdist*xdist+xdist*xdist));
	}
}

class Triangle implements Order{
	private Point v1 = new Point();
	private Point v2 = new Point();
	private Point v3 = new Point();
	
	void get(){
		v1.get(); v2.get(); v3.get();
	}
	
	public String toString(){
		return v1.toString() + "-" + v2.toString() + "-" + v3.toString();
	}
	
	public double area(){ // area of the triangle
		double a = v1.distance(v2);
		double b = v2.distance(v3);
		double c = v3.distance(v1);
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	} 
	
	public boolean lte(Object obj){
		if(obj == null) return false;
		Triangle t = (Triangle) obj;
		return area() <= t.area();
	}
}

class OrderTest{
	static void sort(Order[] w) { // Sort w[0..]
		final int n = w.length;
		int j = 0; // w[j..] to be sorted
		while (j<n-1) {
			int min = j;  
			int i = j+1;
			while (i<n) {
				if (w[i].lte(w[min]))
					min = i;
				i++; 
			}
			Order temp= w[j];
			w[j] = w[min]; w[min] = temp;
			j++;
		}
	}
	public static void main(String[] args){
		  Triangle[] ts = new Triangle[3];
		  System.out.println(
			  "Enter " + ts.length + " triangles:");
			for (int i=0; i<ts.length; i++){
				ts[i] = new Triangle(); ts[i].get();
			}
			sort(ts);
			for (Triangle t: ts)
				System.out.println(t);
	       }
}

