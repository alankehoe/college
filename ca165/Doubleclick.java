import graphics.*;

public class Doubleclick
{
	public static void main(String [] args)
	{
		while(true)
		{
			Window win = new Window(100, 100);
	      		long start= 0;
			long stop= 0;
			int i = 0;
			
			while(!win.isPressed())
			{
			System.out.print("");
			}
			
			start = System.currentTimeMillis();
			
			while(win.isPressed())
			{
			System.out.print("");
			}
			
			stop = System.currentTimeMillis();
		
		System.out.println("Time required was " + (stop - start) + " milliseconds.");
		}
	}
}

