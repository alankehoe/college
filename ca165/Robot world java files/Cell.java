
import java.awt.*;

public class Cell
{
	private boolean hasWall;
	private boolean hasTrack;
	private int numBeepers;

	boolean redraw;

	private Robot robot;

	boolean isWall() { return hasWall; }
	boolean isRobot() { return robot != null; }
	Robot getRobot() { return robot; }
	boolean isTrack() { return hasTrack; }
	int getNumBeepers() { return numBeepers; }

	void setWall(boolean b) { hasWall = b; }
	void setRobot(Robot r) { robot = r; }
	void setTrack(boolean b) { hasTrack = b; }
	void setNumBeepers(int n) { numBeepers = n;}
	void incBeepers() { numBeepers++;}
	void decBeepers() { numBeepers--;}

	boolean toBeRedrawn() { return redraw; }
	void setRedraw(boolean b) { redraw = b; }

	// Kludgy, required by DrawableCell. Should use interface but feckit.
	void setSize(int a, int b, int c, int d) {}
	void setSize(int a, int b, int c) {}
	void draw(Graphics g){}
	void mark(Graphics g){}
	void unMark(Graphics g){}
	void drawObject(Graphics g){}
	void drawBorder(Graphics g){}

	int getX() { return 0;}
	int getY() {return 0; }
	int getWidth() {return 0; }

	Cell()
	{
		setWall(false);
		setRobot(null);
		setTrack(false);
		setNumBeepers(0);
		setRedraw(true);
		setRedraw(false);
	}

	boolean canEnter()
	{
		return !(isRobot() || isWall());
	}

	// Anything in this cell?
	boolean hasObject()
	{
		return isRobot() || isWall() || getNumBeepers() > 0 || isTrack();
	}

	boolean add(Robot r)
	{
		if(canEnter())
			{
			robot = r;
			setRedraw(true);
			return true;
			}
		return false;
	}

	void removeRobot()
	{
		robot = null;
		setTrack(true);
		setRedraw(true);
	}

	boolean addWall()
	{
		// can't add a wall over a wall, robot or a beeper.
		if(isWall() || isRobot() || getNumBeepers() > 0)
			return false;

		setWall(true);
		setRedraw(true);
		return true;
	}

	boolean add(Wall w)
	{
		return addWall();
	}

	boolean addBeeper()
	{
		if(isWall())
			return false;

		incBeepers();
		setRedraw(true);
		return true;
	}

	boolean add(Beeper b)
	{
		return addBeeper();
	}

	boolean removeBeeper()
	{
		if(getNumBeepers() < 1)
			return false;

		decBeepers();
		setRedraw(true);
		return true;
	}

	public String toString()
	{
		if(isRobot())
			return getRobot().toString();
		if(getNumBeepers() > 1)
			return "" + getNumBeepers() + " beepers";
		else if(getNumBeepers() == 1)
			return "1 beeper";
		else if(isWall())
			return "block";
		return "";
	}

	static String toString(int x, int y)
	{
		return "cell (" + x + ", " + y + ")";
	}
}
