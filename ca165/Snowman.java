import graphics.*;

public class Snowman
{
	public static void main (String [] args)
	{
	Window win = new Window(400, 400);
	
	Circle c1 = new Circle(200, 350, 50); 
	win.draw(c1);
		                            
	Circle c2 = new Circle(200, 260, 40);
	win.draw(c2);
	                       
	Circle c3 = new Circle(200, 190, 30);
	win.draw(c3);
	
	Circle c4 = new Circle(200, 140, 20);
	win.draw(c4);
	
	Circle c5 = new Circle(200, 110, 10);
	win.draw(c5);	
	}
}
