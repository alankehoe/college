import graphics.*;

public class ColouredLine
{
	public static void main (String [] args)
	{
		Window win = new Window (500,500);
		
		int r = 250;
		int g = 0;
		int b = 125;
		for (int x = 150;x < 400; x++)
		{
			//if(r>0)
			//{
			//	r--;
			//}
			//else
			//{
			//	r++;
			//}
			g++;
			r--;
			//System.out.println(r);
			Color shade = new Color(r,g,b);
			win.setForeground(shade);
			Line square = new Line(x,250,x,400);
			win.draw(square);	
		}
	}
}
