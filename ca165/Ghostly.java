import graphics.*;

public class Ghostly
{
	public static void main (String [] args)
	{
		Window win = new Window(500, 500);
		Circle c1 = new Circle(255, 255, 0);
		
		int count = 0;
		
		for (count = 0;count <= 255; count++)
		{	
			Color shade = new Color (count, count, count);
			win.setForeground(shade);
			
			c1.expand(1,1);
			
			win.draw(c1);
		}
	}	
}
