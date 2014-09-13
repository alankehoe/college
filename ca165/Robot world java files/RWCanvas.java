import java.awt.*;
import java.awt.event.*;

public class RWCanvas extends Canvas
{
	static final int XBORDER = 1;
	static final int YBORDER = 1;
	static final int MINWIDTH = 16;
	private int numX, numY;
	private int sizeX = 0, sizeY = 0;
	private Cell [][] grid = null;

	private static Color defaultBackColour = Color.green;
	static void setDefaultBackColour(Color c) { defaultBackColour = c; }

	private static Color defaultForeColour = Color.white;
	static void setDefaultForeColour(Color c) { defaultForeColour = c; }

	Cell [][] getGrid() { return grid; }
	int getNumX() { return numX; }
	int getNumY() { return numY; }
	void setXY(int x, int y)
	{
		numX = x; numY = y;
		grid = createGrid(numX, numY, defaultBackColour, defaultForeColour);
		initCells();
	}

	Point marked, clear;

	private Color background;
	private Color borderColour;
	private Color coordBackground;

	RWCanvas()
	{
		this(500, 500, 20, 20);
	}

	RWCanvas(int w, int h, int numX, int numY)
	{
		this(w, h, numX, numY, Color.green);
	}

	RWCanvas(int w, int h, int numX, int numY, Color c)
	{
		this(w, h, numX, numY, c, defaultForeColour);
	}

	RWCanvas(int w, int h, int numX, int numY, Color b, Color f)
	{
		//background = defaultBackColour; // background colour for the cells
		//borderColour = defaultForeColour; // border
		background = b; // background colour for the cells
		borderColour = f; // border

		coordBackground = Color.white;

		setBackground(coordBackground);

		// number of cells in the grid
		if(numX < 1) numX = 1;
		if(numY < 1) numY = 1;
		this.numX = numX;
		this.numY = numY;

		grid = createGrid(numX, numY, background, coordBackground);

		initCells(w, h);

		addMouseMotionListener(new MouseMotionAdapter()
			{
				public void mouseMoved(MouseEvent e){ processMouse(e); }
				public void mouseDragged(MouseEvent e){ processMouse(e); }
			});
		addMouseListener(new MouseAdapter()
			{
				public void mouseExited(MouseEvent e){ unMark(getGraphics(), marked); marked = clear; }
			});
	}

	Cell [][] createGrid(int numX, int numY, Color back, Color coord)
	{
		// Create the cells (extra row and column for the co-ordinate labels)
		grid = new Cell[numX+1][numY+1];

		// This is the main board
		for(int x = 1; x <= numX; x++)
			for(int y = 1; y <= numY; y++)
				grid[x][y] = new DrawableCell(background);

		// Co-ordinates, fill in the numbers
		for(int x = 1; x <= numX; x++)
			grid[x][0] = new BorderCell(coordBackground, x - 1);
		for(int y = 1; y <= numY; y++)
			grid[0][y] = new BorderCell(coordBackground, y - 1);

		grid[0][0] = new BorderCell(coordBackground, -1); // lower left corner: no label.

		return grid;
	}

	void mark(Graphics g, Point p)
	{
		//grid[p.x][p.y].mark(g); // cell
		// print a status message
		try {
			RWGui f = (RWGui) getParent();
			f.statusMessage(grid[p.x][p.y].toString());
			}
		catch(Exception e) {}// may not be in an RWFrame, or have a status window

		grid[p.x][0].mark(g);   // border
		grid[0][p.y].mark(g);   // border
	}

	void unMark(Graphics g, Point p)
	{
		grid[p.x][0].unMark(g);   // border
		grid[0][p.y].unMark(g);   // border
	}

	// The mouse has moved, mark the affected coordinates
	void processMouse(MouseEvent e)
	{
   	Point p = getCoords(e.getX(), e.getY());

		if(marked.equals(p))
			return; // if still in same cell ignore

		// a new cell
		Graphics g = getGraphics();
		//grid[marked.x][marked.y].unMark(g); // unmark the old cell
		if(inWorld(p))
			{
			// Unmark the borders (if changed)
			if(marked.x != p.x) grid[marked.x][0].unMark(g);
			if(marked.y != p.y) grid[0][marked.y].unMark(g);

			marked = p; // remember the old marked cell
			mark(g, marked);
			}
		else
			{
			// Not in the world, unmark the borders
			grid[marked.x][0].unMark(g);
			grid[0][marked.y].unMark(g);
			marked = clear;
			}
	}

	void initCells()
	{
		Dimension s = getPreferredSize();
		initCells(s.width, s.height);
	}

	// Initialise all the cells (width, height and staring coordinates)
	void initCells(int w, int h)
	{
		// Now initialise the cells (work out width and height)
		int cellWidth = (w-XBORDER) / (numX+1) - 1; // allow 1 pixel border
		int cellHeight = (h-YBORDER) / (numY+1) - 1;

/*		int width = Math.min(cellWidth, cellHeight);*/
		if(cellWidth < MINWIDTH) cellWidth = MINWIDTH;
		if(cellHeight < MINWIDTH) cellHeight = MINWIDTH;

		// Adjust the canvas so the grid fits snugly
		sizeX = (cellWidth+1) * (numX+1) + 1;
		sizeY = (cellHeight+1) * (numY+1) + 1;

		for(int x = 0; x <= numX; x++)
			for(int y = 0; y <= numY; y++)
				{
				int startX = 1 + x * (cellWidth+1); // allow border(s)
				int startY = 1 + (numY - y) * (cellHeight+1);
				grid[x][y].setSize(startX, startY, cellWidth, cellHeight);
				}

		// size of the canvas
		setSize(sizeX, sizeY);

		// Have mouse mark cells
		marked = clear = new Point(0, 0);
	}

	// This draws the world, the cells, the borders and the coordinates
	void fastDraw(Graphics g)
	{
		// rather than draw each cell individually, draw all together => less flicker on startup
		DrawableCell base = (DrawableCell) grid[1][1];

		g.setColor(base.getColour());

		int width = base.getWidth();
		int height = base.getHeight();

		// Get extent of playing field
		int xLow = base.getX();
		int xHigh = xLow + numX * (width+1) - 1;

		int yLow = grid[1][numY].getY();
		int yHigh = yLow + numY * (height+1) - 1; // y works in reverse

		// splat out the whole rectangle
		g.fillRect(xLow, yLow, xHigh-xLow, yHigh-yLow);

		// draw the lines
		g.setColor(borderColour);

		// done the internal surface, expand by one pixel for the border
		xLow--; yLow--;;

		// vertical lines
		for(int x = 0; x <= numX; x++)
			g.drawLine(xLow + x * (width+1), yLow, xLow + x * (width+1), yHigh);

		// horiz lines
		for(int y = 0; y <= numY; y++)
			g.drawLine(xLow, yLow + y * (height+1), xHigh, yLow + y * (height+1));

		// draw the co-ordinates
		for(int x = 1; x <= numX; x++)
			grid[x][0].drawObject(g);
		// then the y-axis
		for(int y = 1; y <= numY; y++)
			grid[0][y].drawObject(g);

		// draw the border above and below the coordinates (separates the
		// status and control window if there).
/*		xLow -= width+1;
		g.drawLine(xLow, yLow, xHigh, yLow);
		g.drawLine(xLow, yLow + (numY+1) * (height+1), xHigh, yLow + (numY+1) * (height+1));*/
	}

	public void paint(Graphics g)
	{
		// draws the background
		fastDraw(g);

		// Draw the cells themselves
		for(int x = 1; x <= numX; x ++)
			for(int y = 1; y <= numY; y ++)
				if(grid[x][y].hasObject())
					grid[x][y].drawObject(g); // only draw if someat to draw

		// Do we need to mark the coordinates of the mouse cell?
		if(marked != clear)
			mark(g, marked); // yes ... mark the coordinates
	}

	// Update only needs to draw a cell if something has changed.
	public void update(Graphics g)
	{
		// for each cell in the grid ...
		for(int x = 1; x <= numX; x ++)
			for(int y = 1; y <= numY; y ++)
				grid[x][y].draw(g); // ... draw it
	}

	// Used to convert the mouse coordinates to cell coordinates
	private Point getCoords(int x, int y)
	{
		DrawableCell base = (DrawableCell) grid[1][1];

		// divide by size of cell
		x = x / (base.getWidth()+1);
		y = y / (base.getHeight()+1);
		y = numY - y; // convert y to math coord
		return new Point(x, y);
	}

	// Are these cell coordinates valid (in the world)?
	private boolean inWorld(Point p)
	{
		return p.x > 0 && p.y > 0 && p.x <= numX && p.y <= numY;
	}

	public static void main(String [] args)
	{
		ClosableFrame f = new ClosableFrame();

		f.setLayout(new BorderLayout());
		RWCanvas can = new RWCanvas(600, 600, 20, 15);
		f.add(can, BorderLayout.CENTER);

		f.pack();

		f.setVisible(true);
	}
}

/* Junk code */
//		f.setSize(400, 400);
//		RWCanvas can = new RWCanvas(f.getSize().width, f.getSize().height, 20, 20);
