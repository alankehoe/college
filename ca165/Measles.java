import graphics.*;

public class Measles
{
	public static void main(String [] args)
        {
        	Window win = new Window(600, 400);
        	
		while(true) // loop forever
			if(win.isPressed())
		        {
		        	Point mouse = win.getMouse();
		                int x = mouse.getX();
				int y = mouse.getY();
		                win.fill(new Circle(x, y, 5));
		                System.out.print("");
		        }
        }
}

