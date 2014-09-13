import java.util.Vector;
import java.awt.*;

public class World
{
	final boolean debug = false;
	// change in direction of x,y for a particular direction
	//								N   W   S  E
	static int [] moveX = { 0, -1,  0, 1};
	static int [] moveY = { 1,  0, -1, 0};

	// NB. this can be the only instance variable if want to run
	// successfully as an applet.
	private RWGui gui;

	RWGui getGui() { return gui; }
	void setGui(RWGui f) { gui = f; }

	static World appletWorld = null; // used to hijack standalone application's worlds.
	static void setWorld(World w) { appletWorld = w; }
	
	static RWGui appletGui = null; // used to hijack standalone application's worlds.
	static void setAppletGui(RWGui g) { appletGui = g; }

	static void setColour(String colour)
	{
		if("printable".equalsIgnoreCase(colour))
			{
			RWCanvas.setDefaultBackColour(Color.white);
			RWCanvas.setDefaultForeColour(Color.black);
			Robot.setDefaultColour(Color.black);
			StatusWindow.setDefaultBackColour(Color.white);
			StepControls.setDefaultBackColour(Color.white);
			}
	}

	public World()
	{
		this(15, 15);
	}

	public World(int numX, int numY)
	{
		this(450, 450, numX, numY, Color.green);
	}

	World(int w, int h, int numX, int numY, Color c)
	{
		this(w, h, numX, numY, c, Color.white);
	}

	World(int w, int h, int numX, int numY, Color b, Color f)
	{
		if(appletWorld != null)
			{
			// kludge to handle applets
			setGui(appletWorld.getGui());
			gui.setXY(numX, numY);
			}
		else
			{
			gui = new RWFrame();
			gui.init(this, w, h, numX, numY, b, f);

			// Place in centre of screen
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = gui.getSize();
			gui.setLocation((screen.width-frameSize.width)/2, (screen.height-frameSize.height)/2);
			gui.setVisible(true);
			}

		startCheckerThread();
	}

	void startCheckerThread()
	{
		Thread t = Thread.currentThread();
		int p = t.getPriority();
		t.setPriority(p - 1);
		gui.redraw();
		Thread.yield(); // so screen can be redrawn before thread started.

		new Checker(Thread.currentThread(), this).start();
		t.setPriority(p);
	}

	// constructor for use by applet
	World(RWGui a) { gui = a; }

	// Normally used by an applet to change the coordinates
	public void setSize(int x, int y)
	{
		gui.setXY(x, y);
	}

	// This method is for use by another environment
	public void go()
	{
		gui.setRunTime(10000);
		gui.setRun(true);
		gui.controlMessage("Running", Color.blue);
	}

	// This method is for use by another environment
	public void go(int rt)
	{
		gui.setRunTime(rt);
		gui.setRun(true);
		gui.controlMessage("Running", Color.blue);
	}

	// This finds cell(x, y). It converts indices. If out of bound, returns null
	Cell getCell(int x, int y)
	{
		if(!inBounds(x, y))
			{
			errorMessage(x, y, " is out of bounds");
			// Shouldn't return
			return null;
			}

		return gui.getGrid()[x+1][y+1];
	}

	// convenience method to get the cell the robot's in.
	Cell getCell(Robot r)
	{
		return getCell(r.getX(), r.getY());
	}

	boolean inBounds(int x, int y)
	{
		return x >= 0 && y >= 0 && x < gui.getNumX() && y < gui.getNumY();
	}

	public void add(Robot r)
	{
		add(r, 0, 0);
	}

	public void add(Robot r, int x, int y)
	{
		add(r, x, y, "east");
	}

	public void add(Robot r, int x, int y, String dir)
	{
		if(!(r instanceof BasicRWItem))
			{
			System.out.println("There may be a file 'Robot.class' in your directory");
			errorMessage("This is not a proper Robot");
			}
		else if(r.inWorld())
			{
			errorMessage("This robot is already in a world");
			return;
			}
		Cell cell = getCell(x, y);
		if(cell.canEnter())
			{
			//sync();
			r.setWorld(this);
			r.init(x, y, dir);

			cell.add(r);
			if(r instanceof Automaton)
				addAuto((Automaton) r);

			gui.redraw(); // Paint the robot
			}
		else
			errorMessage(Cell.toString(x,y) + " is occupied");
	}

	public void addAuto(Automaton r)
	{
		if(gui.getAutomata() == null)
			gui.setAutomata(new Vector());

		new Thread(r).start(); // should yield immediately to be started when notified
		gui.getAutomata().addElement(r);
	}

	public void addWall(int x, int y, int len, String direction)
	{
		int dir = Util.getDir(direction);
		for(int i = 0; i < len; i++)
			if(getCell(x + i * moveX[dir], y + i * moveY[dir]).addWall() == false)
				{
				errorMessage(x + i * moveX[dir], y + i * moveY[dir],
									" is occupied");
				break;
				}
		gui.redraw();
	}

	void add(Wall w, int x, int y, String direction)
	{
		addWall(x, y, w.getLength(), direction);
	}

	public void addBlock(int x, int y)
	{
		addWall(x, y, 1, "north");
	}

	void add(Wall w, int x, int y)
	{
		if(w.getLength() > 1)
			errorMessage("The wall must have a direction.");
		else
			addBlock(x, y);
	}

	void add(Beeper b, int x, int y)
	{
		addBeeper(x, y);
	}

	public void addBeeper(int x, int y)
	{
		if(getCell(x , y).addBeeper() == false)
			errorMessage("Can't add beeper to " + Cell.toString(x, y));
		else
			gui.redraw();
	}

	boolean frontIsClear(Robot r)
	{
		int nextX = r.getX() + moveX[r.getDir()];
		int nextY = r.getY() + moveY[r.getDir()];

		if(!inBounds(nextX, nextY))
			return false;
		Cell c = getCell(nextX, nextY);
		return c.canEnter();
	}

	boolean beeperPresent(Robot r)
	{
		Cell c = getCell(r);
		return c.getNumBeepers() > 0;
	}

	void update(Robot r)
	{
		if(!(r instanceof Automaton))
			sync();
		int x = r.getX();
		int y = r.getY();

		getCell(x, y).setRedraw(true);
		gui.redraw();
	}
	
	void move(Robot r)
	{
		if(!(r instanceof Automaton))
			sync();
		int x = r.getX();
		int y = r.getY();
		int nextX = x + moveX[r.getDir()];
		int nextY = y + moveY[r.getDir()];

		Cell next = getCell(nextX, nextY);
		if(next.canEnter())
			{
			Cell old = getCell(x, y);
			old.removeRobot();
			next.add(r);
			r.setX(nextX);
			r.setY(nextY);
			}
		else
			errorMessage("Crash: (" + x + ", " + y + ")");
		gui.redraw();
	}

	void turnLeft(Robot r)
	{
		if(!(r instanceof Automaton))
			sync();
		// change the direction
		r.setDir((r.getDir() + 1) % 4);

		// tell the cell to redraw itself
		getCell(r).setRedraw(true);
		gui.redraw();
	}

	void putBeeper(Robot r)
	{
		if(!(r instanceof Automaton))
			sync();

		if(r.getNumBeepers() < 1)
			errorMessage("The robot has no beepers to drop");
		else
			{
			Cell cell = getCell(r);
			cell.addBeeper();
			gui.redraw();
			}
	}

	void pickBeeper(Robot r)
	{
		if(!(r instanceof Automaton))
			sync();
		Cell cell = getCell(r);
		if(cell.removeBeeper() == false)
			errorMessage("There is no beeper to pick at " + Cell.toString(r.getX(), r.getY()));
		gui.redraw();
	}

	long getDelay()
	{
		int runTime = gui.getRunTime();
		if(runTime < 1) runTime = 1;
		int delay = (int) (100000.0 / runTime);
		if(delay < 1)
			delay = 1;
		else if(delay > 3000)
			delay = 3000; // three seconds max
		return delay;
	}

	private void debugPrint(String s)
	{
		if(debug)
			System.out.print(s);
	}

	synchronized void sync()
	{
		try
			{
			if(gui.getRun())
				{
				debugPrint(".");
				wait(getDelay());
				debugPrint(".");
				}
			else
				{
				debugPrint("*");
				wait();
				debugPrint("*");
				}
			}
		catch(InterruptedException e) {System.out.println("Sync intrupted");}
	}

	void errorMessage(String msg)
	{
		gui.errorMessage(msg);
		gui.redraw();

		// to switch off the Automata
		gui.setRun(false);
		gui.setAutomata(null);
		// wait ... program shouldn't continue on error.

		while(true)
			try {Thread.sleep(100000);}
			catch(Exception e) { e.printStackTrace(); }
		
/*		while(true)
			{
			System.out.print('.');
			try {wait(10000);} catch(Exception e) {System.out.print(e);}
			}*/
	}

	void errorMessage(int x, int y, String msg)
	{
		errorMessage(Cell.toString(x, y) + " " + msg);
	}

	void startAutomata()
	{
		// Now tell any automata to run
		Vector automata = gui.getAutomata();
		if(automata != null)
			{
			boolean done = false;
			while(!done)
				{
				done = true;
				debugPrint("-");
				sync();
				debugPrint("-");
				try{
					for(int i = 0; i < automata.size(); i++)
						{
						debugPrint(""+i);
						Automaton auto = ((Automaton) automata.elementAt(i));
						if(!auto.finished())
							{
							synchronized(auto)
								{ auto.notify(); }// tell this robot to make a move

							done = false; // still not finished
							}
						else
							debugPrint(" (done)");
						debugPrint(", ");
						}
					}
				catch(NullPointerException e) { done = true; }
				debugPrint("\n");
				}
			}
	}

	void finished()
	{
		gui.controlMessage("Finished", Color.blue);
		gui.redraw();
	}

	public static void main(String [] args)
	{
		World w = new World();
	}
}

// This class simply observes when the main thread has finished,
// i.e. robot program finished. Required for automated marking.
class Checker extends Thread
{
	Thread mainThread;
	World world;

	Checker(Thread mainThread, World w)
	{
		this.mainThread = mainThread;
		world = w;

		setPriority(Thread.MIN_PRIORITY);
	}

	public void run()
	{
		boolean done = false;
		while(!done)
			{
			try {
				mainThread.join();
				done = true;
			} catch(InterruptedException e) { System.out.println("main interrupted"); }
			}

		world.startAutomata(); // Get any automata to run
		world.finished(); // Tell the world that main is finished
		// mainThread.start(); didna work
	}
}

