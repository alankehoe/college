
import java.awt.*;

/* The code to draw the robots, walls, beepers and tracks
** is based on the code of JavaBOTL by Jonathan M Bourgeois.
**
**
** Changed 2 Feb 01 to fix redraw problem
** changed 10 Sep 01, remove superfluous check for wall in draw(Graphics g)
*/

public class DrawableCell extends Cell
{
	private int baseX, baseY;
	private int width, height;
	Color colour;

	int getX() { return baseX; }
	int getY() { return baseY; }
	int getWidth() { return width; }
	int getHeight() { return height; }
	Color getColour() { return colour; }

	DrawableCell()
	{
		this(0, 0, 0, 0, Color.green);
	}

	DrawableCell(Color c)
	{
		this(0, 0, 0, 0, c);
	}

	DrawableCell(int x, int y, int w, int h, Color c)
	{
		baseX = x;
		baseY = y;
		width = w;
		height = h;
		colour = c;
	}

	DrawableCell(int x, int y, int w, Color c)
	{
		this(x, y, w, w, c);
	}

	void setSize(int x, int y, int w)
	{
		setSize(x, y, w, w);
	}

	void setSize(int x, int y, int w, int h)
	{
		baseX = x;
		baseY = y;
		width = w;
		height = h;
	}

	void setColour(Color c)
	{
		colour = c;
	}

	void drawBorder(Graphics g)
	{
		g.drawRect(baseX - 1, baseY - 1, width + 1, height + 1);
	}

	void erase(Graphics g)
	{
			// erase the cell (fill with colour)
			erase(g, colour);
	}

	void erase(Graphics g, Color c)
	{
			// erase the cell (fill with colour)
			g.setColor(c);
			g.fillRect(baseX, baseY, width, height);
	}

	void drawBeeper(Graphics g)
	{
   	g.setColor(Color.orange);

		g.drawOval(baseX + width/4, baseY + height/4, width/2, height/2);
		g.fillOval(baseX + width/4, baseY + height/4, width/2, height/2);
	}

	void drawTrack(Graphics g)
	{
		g.setColor(Color.red);
		g.drawLine(baseX + width/2 - 1, baseY + height/2 - 1
					 , baseX + width/2 + 1, baseY + height/2 + 1);
		g.drawLine(baseX + width/2 - 1, baseY + height/2 + 1
					 ,baseX + width/2 + 1, baseY + height/2 - 1);
	}

	void drawWall(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(baseX, baseY, width, height);

		g.setColor(Color.black);

		for(int i=0;i<3;i++)
			{
// CD			g.drawLine(baseX + (int)Math.round(i*(width - 1.0)/3), baseY, baseX, baseY + (int)Math.round(i*(height-1.0)/3));
			g.drawLine(baseX + i*width/3, baseY, baseX, baseY + i*height/3);
// CD		g.drawLine(baseX + (int)Math.round((3-i)*(width - 1.0)/3), height - 1 + baseY, baseX+width - 1, baseY + (int)Math.round((3-i)*(height-1.0)/3));
			g.drawLine(baseX+(3-i)*width/3, height + baseY, baseX+width, baseY+(3-i)*height/3);
			}
		g.drawLine(baseX + width, baseY, baseX, baseY + height);
	}

	void drawRobot(Graphics g)
	{
		g.setColor(getRobot().getColour());
		switch(getRobot().getDir())
			{
			case 0:
				for(int i=0; i < height/4; i++)
					{
					g.drawLine(baseX + width/2, baseY + height/4 + i
								 , baseX + width/4, baseY+height/2+i);
					g.drawLine(baseX + width/2, baseY + height/4 + i
								 , baseX + 3*width/4, baseY + height/2 + i);
					}
				break;

			case 1:
				for(int i=0; i < width/4; i++)
					{
					g.drawLine(baseX + width/4 + i, baseY + height/2
								 , baseX + width/2 + i, baseY + height/4);
					g.drawLine(baseX + width/4 + i, baseY + height/2
								 , baseX + width/2 + i, baseY + 3*height/4);
					}
				break;

			case 2:
				for(int i=0;i<height/4;i++)
					{
					g.drawLine(baseX + width/2, baseY + 3*height/4 - i
								 , baseX + width/4, baseY + height/2 - i);
					g.drawLine(baseX + width/2, baseY + 3*height/4 - i
								 , baseX + 3*width/4, baseY + height/2 - i);
					}
				break;

			case 3:
				for(int i=0; i < width/4; i++) // West
					{
					g.drawLine(baseX + 3*width/4 - i, baseY + height/2
								 , baseX + width/2 - i, baseY + height/4);
					g.drawLine(baseX + 3*width/4 - i, baseY + height/2
								 , baseX + width/2 - i, baseY + 3*height/4);
					}
				break;

			default:
				Util.errorMessage("Invalid Robot direction");
				break;
			}
	}

	void draw(Graphics g)
	{
		if(toBeRedrawn())
			{
			// Shouldn't be necessary (was before 'cos of redraw big)
			// if(!isWall()) // no need to erase if it's a wall (less flicker)
			erase(g);
			drawObject(g);
			}
	}

	void drawObject(Graphics g)
	{
		if(getNumBeepers() > 0)
			drawBeeper(g); // Beeper may be viewed under robot => draw before and no else
		if(isRobot())
			drawRobot(g);
		else if(isWall())
			drawWall(g); // if there's a robot => no wall.
		else if(isTrack() && getNumBeepers() <= 0)
			drawTrack(g);

		setRedraw(false); // Mark as drawn

		//mark(g); // used for debug
	}

	// Draw a border round the cell to indicate it's been drawn.
	void mark(Graphics g)
	{
		g.setColor(Color.red);
		g.drawRect(baseX, baseY, width-1, height-1);
	}

	void unMark(Graphics g)
	{
		erase(g);
      drawObject(g);
	}

	void drawString(Graphics g, String s)
	{
		Util.centreText(s, g, Color.black, baseX, baseY, width, height);
	}
}
