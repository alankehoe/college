import graphics.*;

public class Graph
{
	public static void main (String [] args)
	{

		System.out.println("enter X value");
		double x =Console.readDouble();
		System.out.println("enter Y value");
		double y =Console.readDouble()* 50 + 0.5;
		double sinx = Math.sin(x)* 50 + 0.5;
		
		Window win = new Window(1000, 1000);
		Line xaxis = new Line(100 ,100 ,1000 ,100);
		Line yaxis = new Line(100, 100, 100, 1000);
		
		win.draw(xaxis);
		win.draw(yaxis);
		
		int ypixel = (int) y;
		int xpixel = (int) sinx;
		
		Line output = new Line(100 ,100 ,(xpixel) ,(ypixel));
		win.draw(output);
				
	}
}
