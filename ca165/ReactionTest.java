import graphics.*;

// this program works on the basis that you click the circle and then it displays your reaction time however if you dont click the circle it will generate another random circle and will not give you a reaction time, you get 10 goes at testing your reaction time as anymore than 10 seemed to crash the computer as the memory ran out or something like that, i tested this program continously to make sure it was working ok and as far as i could see it had no bugs...
public class ReactionTest
{
	public static void main (String [] args)
	{
		System.out.println("The aim of the game is to click within the circle in the quickest time possible and the program gives you back your reaction time. You have 10 trys befroe the program quits ");
		int count = 0;
		for(count = 0;count < 11;count++)
		{	
			Window win = new Window(1000,1000);
			Color aqua = new Color(93,255,194);
			win.setForeground(aqua);
			long start = 0;
			long stop = 0;		
			start = System.currentTimeMillis();
			double randomX = Math.random()*500;
			double randomY = Math.random()*500;
			int x = (int)randomX;
			int y = (int)randomY;
			long best =stop-start;
			System.out.println("x = " + x);
			System.out.println("y = " + y);
			
			while(!win.isPressed())
			{
				System.out.print("");	
			
				Circle circ = new Circle(x,y,50);
				win.fill(circ);
				Point mouse = win.getMouse();
			
				if (win.isPressed() && circ.contains(mouse))
				{
					win.clear(circ);
					stop = System.currentTimeMillis();
					System.out.println("Your reaction was " + (stop - start) + " Milliseconds");
				}
			}
		}
		System.out.println("Game over, Have another go !!! ");						
	}
}
