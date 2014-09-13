class Triangle{
	private Point v1 = new Point();
	private Point v2 = new Point();
	private Point v3 = new Point();
	
	void get(){
		v1.get();
		v2.get();
		v3.get();
	}
	
	public String toString(){
		return v1.toString()+":"+v2.toString()+":"+v3.toString();
	}
	
	double area(){
		double a = v1.distTo(v2);
		double b = v2.distTo(v3);
		double c = v3.distTo(v1);
		double s = (a+b+c)/2;
		return s*(s-a)*(s-b)*(s-c);
	}
}

class AreaTriangle{
	public static void main(String [] args){
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		System.out.println("Enter two triangles");
		t1.get();
		t2.get();
		System.out.print("largest triangle is ");
		if(t1.area() > t2.area())
			System.out.println(t1.toString());
		else
			System.out.println(t2.toString());
	}
}
