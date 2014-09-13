// static methods to support the robots
import java.awt.*;

public class Util
{
	static void centreText(String s, Graphics g, Color c, int x, int y, int w, int h)
	{
		FontMetrics fm = g.getFontMetrics();

		int ascent = fm.getAscent();
		int height = fm.getHeight();

		int width = fm.stringWidth(s);

		int xStart = x + (w-width)/2;
		int yStart = y + (h-height)/2 + ascent; 

		g.setColor(c);
		g.drawString(s, xStart, yStart);
	}

	static Rectangle getTextSize(String s, FontMetrics fm, int x, int y, int w, int h)
	{
		int ascent = fm.getAscent();
		int height = fm.getHeight();

		int width = fm.stringWidth(s);

		int xStart = x + (w-width)/2;
		int yStart = y + (h-height)/2 + ascent;

		return new Rectangle(xStart, yStart, width, height);
	}

	static Color getColour(String colour, Color def)
	{
		Color col = def;
		if("red".equals(colour))
			col = Color.red;
		else if("yellow".equals(colour))
			col = Color.yellow;
		else if("green".equals(colour))
			col = Color.green;
		else if("orange".equals(colour))
			col = Color.orange;
		else if("black".equals(colour))
			col = Color.black;
		else if("white".equals(colour))
			col = Color.white;
		else if("blue".equals(colour))
			col = Color.blue;

		return col;
	}

	static int getDir(String direction, int def)
	{
		int dir = def;
		if("north".equals(direction))
			dir = 0;
		else if("west".equals(direction))
			dir = 1;
		else if("south".equals(direction))
			dir = 2;
		else if("east".equals(direction))
			dir = 3;

		return dir;
	}

	static int getDir(String direction)
	{
		return getDir(direction, 0);
	}

	static void errorMessage(String msg)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();

		errorMessage(msg, new Point(screen.width / 2, screen.height /2));
	}

	static void errorMessage(String msg, Point centre)
	{
		// Want a label in a panel in a frame.
		Frame w = new ClosableFrame("Error message");
		w.setLayout(new BorderLayout());

		Panel p = new Panel();
		w.add(p);

		Label l = new Label(msg, Label.CENTER);

		p.add(l);

//		Dimension d = l.getPreferredSize(); Doesn't work, so use fontmetrics
		Font f = new Font("sans serif", Font.BOLD, 25);
		FontMetrics fm = w.getFontMetrics(f);
		l.setFont(f);

		Dimension min = new Dimension(fm.stringWidth(msg) + 100, fm.getHeight()* 4);

		p.setSize(min);

		w.setBackground(Color.red);
		w.pack();
		w.setVisible(true);

		w.setLocation(centre.x - min.width/2, centre.y - min.height/2);

		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	}

	public static void main(String [] args)
	{
		errorMessage("Test");
	}
}
