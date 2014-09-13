
import java.awt.*;

public class BorderCell extends DrawableCell
{
	int num = -1;

	BorderCell(int n) { num = n; }
	BorderCell(Color c, int n) { super(c); num = n; }

	void draw(Graphics g)
	{
		erase(g); // draw the background
		drawObject(g);
	}

	// Simply prints the number
	void drawObject(Graphics g)
	{
		g.setColor(Color.black);
		if(num >= 0)
			drawString(g, ""+num);
	}

	void mark(Graphics g)
	{
		erase(g, new Color(0xc0, 0xc0, 0xc0));
		drawObject(g);
	}

	void unMark(Graphics g)
	{
		erase(g);
		drawObject(g);
	}

	boolean hasObject() { return num >= 0; }
	boolean canEnter() { return false; }
}