//
//  This class is an applet that loads robot programs
//  and provides the applet environment they need to
//  operate.
//
//  It uses the AppletStart method to try various methods
//  to run.

import java.applet.*;
import java.awt.*;
//import java.lang.reflect.Method;
import java.util.Vector;

public class LoaderApplet extends Applet implements RWGui, Runnable
{
	World world;
	RWCanvas canvas;
	StepControls controls;
	StatusWindow status;

	// These don't belong here, but required 'cos of the applet hack
	Vector automata;
	public void setAutomata(Vector v) { automata = v; }
	public Vector getAutomata() { return automata; }
	protected Thread robotProgram = null;

	public void init()
	{
		world = new World(this);

		setLayout(new BorderLayout());

		add((controls = new StepControls(world)), BorderLayout.NORTH);
		add((status = new StatusWindow()), BorderLayout.SOUTH);

		Dimension space = getSize();
		int hUsed = controls.getPreferredSize().height;
		hUsed += controls.getPreferredSize().height;

		canvas = new RWCanvas(space.width,
									space.height - hUsed
									, 15, 15		// number of cells
									);
//									, new Color(0, 0x80, 0), Color.white);

		add(canvas, BorderLayout.CENTER);

		setBackground(canvas.getBackground());
	}

   public void start()
	{
		if(robotProgram == null)
			{
			robotProgram = new Thread(this);
			robotProgram.start();
			}
	}

	public void run()
	{
		String program = null;
		try
			{
			// Set the default colour before loading any class
			String colour = getParameter("colour");
			if(colour != null)
				World.setColour(colour);

			program = getParameter("program");
			if(program == null)
				world.errorMessage("There is no program");
			else
				{
				AppletStart p = new AppletStart(program);
				world.startCheckerThread();

				// Set the world, so the standard constructor is not called
				World.setWorld(world); // => Applet's GUI is used.

				p.run(world);

				redraw(); // needed for IE5 if there are no robots (on refresh)
				}
			}
		catch(java.lang.NoSuchMethodException e)
			{ world.errorMessage("Cannot run " + program); }
		catch(java.lang.ClassNotFoundException e)
			{ world.errorMessage("Cannot load " + program); }
		catch(Exception e)
			{ e.printStackTrace(); }
	}

	// Methods from Gui interface
	public Cell [][]getGrid() { return canvas.getGrid(); }
	public void redraw() { canvas.repaint(); }
	public void errorMessage(String msg) {	controls.errorMessage(msg); }
	public int getNumX() { return canvas.getNumX(); }
	public int getNumY() { return canvas.getNumY(); }
	public void setXY(int x, int y) { canvas.setXY(x, y); }

	public void controlMessage(String msg, Color c) { controls.message(msg, c); }
	public void statusMessage(String msg) { status.print(msg); }

	// controls (also from gui interface)
	public void setRun(boolean b) { controls.setRun(b); }
	public boolean getRun() { return controls.getRun(); }
	public void setStep(int s)  { controls.setStep(s); }
	public int getStep() { return controls.getStep(); }
	public void decStep() { controls.decStep(); }
	public void setRunTime(int r) { controls.setRunTime(r); }
	public int getRunTime() { return controls.getRunTime(); }

	// required for interface (application specific)
	public void init(World world, int w, int h, int numX, int numY, Color b, Color f){}
}

/*
// junk code
	public void run()
	{
		try
			{
			// find if the class has a start method
			Class c = Class.forName(getParameter("program"));

			Class [] parameters = new Class[1];
			parameters[0] = (new String[0]).getClass();

			Method main = c.getMethod("main", parameters);

			Object [] args = new Object[1];
			args[0] = new String [] {};

			Object o = c.newInstance();
			main.invoke(o, args);

			redraw(); // needed for IE5 if there are no robots (on refresh)
			}
			catch(java.lang.NoSuchMethodException e)
				{ world.errorMessage("Cannot run " + getParameter("program")); }
			catch(Exception e)
				{ e.printStackTrace(); }
	}*/


