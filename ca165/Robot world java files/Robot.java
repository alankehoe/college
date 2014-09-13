import java.awt.Color;

public class Robot extends BasicRWItem implements Constants
{
	private World world = null;
	private int x, y, dir;
	private int numBeepers;

	private static Color defaultColour = Color.blue;
	static void setDefaultColour(Color c) { defaultColour = c; }

	int getNumBeepers() { return numBeepers; }

	int getX() { return x; }
	int getY() { return y; }
	int getDir() { return dir; }

	void setX(int x) { this.x = x; }
	void setY(int y) { this.y = y; }
	void setDir(int dir) { this.dir = dir; }
	void setWorld(World w) { world = w; }
	boolean inWorld() { return world != null; }

	private Color c = null;
	Color getColour() { return c; }
	public void setColour(Color c) { this.c = c; }
	public void setColour(String colour)
	{
		this.c = Util.getColour(colour, defaultColour);
		if(inWorld())
			world.update(this);
	}

	public Robot(String colour)
	{
		this(Util.getColour(colour, defaultColour));
	}

	public Robot() { this(defaultColour); }

	Robot(Color c)
	{
		this.c = c;
		numBeepers = 0;
	}

	void init(int x, int y, String dir)
	{
		this.x = x;
		this.y = y;
		this.dir = Util.getDir(dir, NORTH);
	}

	boolean checkInWorld()
	{
		if(!inWorld())
			{
			errorMessage("This robot is not in a world.");
			// shouldn't get here.
			return false;
			}
		return true;
   }

	public void move()
	{
		if(checkInWorld())
			world.move(this);
	}

	public void turnLeft()
	{
		if(checkInWorld())
			world.turnLeft(this);
	}

	public boolean frontIsClear()
	{
		if(checkInWorld())
			return world.frontIsClear(this);

		return false;
	}

	public void pickBeeper()
	{
		if(checkInWorld())
			{
			world.pickBeeper(this);
			numBeepers++;
			}
	}

	public void putBeeper()
	{
		if(checkInWorld())
			{
			world.putBeeper(this);
			numBeepers--;
			}
	}

	public boolean beeperPresent()
	{
		if(checkInWorld())
			return world.beeperPresent(this);

		return false;
	}

	public boolean hasBeeper()
	{
		if(checkInWorld())
			return numBeepers > 0;

		return false;
	}

	public boolean facingNorth() { return dir == NORTH; }
	public boolean facingEast() { return dir == EAST; }
	public boolean facingSouth() { return dir == SOUTH; }
	public boolean facingWest() { return dir == WEST; }

	void errorMessage(String msg)
	{
		// Crudely generate a stack trace.
/*		try{
			throw new Exception();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		if(world == null)
			Util.errorMessage(msg);
		else
			world.errorMessage(msg);

		while(true)
			try {Thread.sleep(100000);}
			catch(Exception e) { e.printStackTrace(); }

	}

	private static final String [] direction = {"north", "west", "south", "east"};

	public String toString()
	{
		String s = "Robot facing " + direction[dir];
		if(numBeepers >= 1)
			s += ", has " + numBeepers + " beeper";;
		if(numBeepers > 1)
			s += 's';

		return s;
	}
}
