import graphics.*;

public class ClickCircle
{
	public static void main (String [] args)
	{
		Window win = new Window(500,500);
		Circle circ = new Circle(250,250,100);
		win.draw(circ);
		
		int i = 0;
		while(i==0)
		{
			while(!win.isPressed())
			{
				System.out.print("");
			}
		
			if(win.isPressed())
			{
				Point mouse = win.getMouse();
				int x1 = mouse.getX();
		  		int y1 = mouse.getY();
		  		
		  		
		  		double distance = Math.sqrt( (250-x1)*(250-x1) + (250-y1)*(259-y1) );
		  		
		  		if(distance>100)
		  		{
		  			System.out.println("That is outside the circle. Try again.");
		  			Color red = new Color(255 , 0 , 0 );
		  			win.setForeground(red);
		  			win.fill(circ);
		  			
		  		} 
		  		else
		  		{
		  			System.out.println("Inside the circle.");
		  			Color green = new Color(0 , 255 , 0 );
		  			win.setForeground(green);
		  			win.fill(circ);
		  		}
		  		while(win.isPressed())
		  		{
		  			System.out.print("");
				}
			}
		}
	}
}
