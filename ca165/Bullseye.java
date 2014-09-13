import graphics.*;
public class Bullseye
{
	public static void main (String [] args)
	{
		Window win = new Window(500, 500);
		Circle c1 = new Circle(250, 250, 25);
		Circle c2 = new Circle(250, 250, 50);
		Circle c3 = new Circle(250, 250, 75);
		Circle c4 = new Circle(250, 250, 100);
		Circle c5 = new Circle(250, 250, 125);
		
		int i = 0;
	
		for (i = 0; i < 10; i++)
		{
			win.draw(c1);
			c1.expand(1, 1);
			
			win.draw(c2);
			c2.expand(1, 1);
			
			win.draw(c3);
			c3.expand(1, 1);
			
			win.draw(c4);
			c4.expand(1, 1);
			
			win.draw(c5);
			c5.expand(1, 1);
		}
	}
}
