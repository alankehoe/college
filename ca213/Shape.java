abstract class Shape {

    	private String name; // will occur in all extensions
    	
    	Shape(String name0) {name = name0;}

    	abstract double area(); // no body, note abstract

    	abstract double perim();

    	void put() { // will occur in all extensions
        	System.out.println(name + " with area " + area()+" and perimeter " + perim());
        }	
}

class Rectangle extends Shape {

    	private double width, height; // & name inherited
    	
    	Rectangle(String s, double w, double h) {
    		super(s); // use Shape constructor; effect is name=s;
    		width = w; height = h;
    	}

    	double area() {return(width*height);} // body added

    	double perim() {return((width+height)*2);} // body added
}

class Triangle extends Shape {

	private double a, b, c; // lengths of sides

	Triangle(String s, double x, double y, double z) {
		super(s);
		a = x; b = y; c = z;
	}

	double area() {
		double s = (a+b+c)/2.0;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	double perim() {return(a+b+c);}
}

class Circle extends Shape{
	
	private double rad;
	
	Circle(String s, double r){
		super(s);
		rad = r;
	}
	
	double area(){
		return 3.14*(rad*rad);	
	}
	
	double perim(){
		return 2 * (3.14 * rad);
	}
}

class testShape{
	public static void main(String args[]) {
		Shape[] figures = {new Rectangle("Rectangle", 2.0, 3.0), new Rectangle("Square", 4.0, 4.0),
		new Circle("Circle", 2.0)};
		for (Shape s: figures) 
			s.put();
	}
}
