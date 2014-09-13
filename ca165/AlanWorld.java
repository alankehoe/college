import graphics.*;

public class AlanWorld
{
	public static void main (String [] args)
	{
		Window win = new Window(600 ,600);

		Color green = new Color(0 , 255 , 0 );	
		Color black = new Color(35 , 35 , 35 );	
		win.setForeground(green);
		Rectangle back = new Rectangle (0 , 0, 600 ,600);
		win.fill(back);
		
		

		
		for (int x = 0; x < 600; x += 40) 
		{
			win.setForeground(black);
			Line vert = new Line(x , 0, x ,600);
			win.draw(vert);
		}
		
		for (int y = 0; y < 600; y += 40) 
		{
			win.setForeground(black);
			Line vert = new Line(0 , y, 600 ,y);
			win.draw(vert);
		}
		
	}
}
