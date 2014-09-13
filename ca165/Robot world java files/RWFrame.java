
import java.awt.*;
import java.util.Vector;

public class RWFrame extends ClosableFrame implements RWGui
{
	RWCanvas canvas;
	Dimension size = null;
	Color background;
	RWCanvas getCanvas() { return canvas; }
	StepControls controls;
	StatusWindow status;

	// These don't belong here, but required 'cos of the applet hack
	Vector automata;
	public void setAutomata(Vector v) { automata = v; }
	public Vector getAutomata() { return automata; }

	RWFrame() { }

	RWFrame(int w, int h, int numX, int numY) { init(w, h, numX, numY); }

	public void init() {	init(550, 550, 21, 21);	}

	public void init(int w, int h, int numX, int numY)
	{
		init(w, h, numX, numY, Color.green);
	}

	public void init(int w, int h, int numX, int numY, Color c)
	{
		init(w, h, numX, numY, c, Color.black);
	}

	public void init(int w, int h, int numX, int numY, Color b, Color f)
	{
		setLayout(new BorderLayout());
		canvas = new RWCanvas(w, h, numX, numY, b, f);
		add(canvas, BorderLayout.CENTER);

		setBackground(canvas.getBackground());
	}

	public void init(World world, int w, int h, int numX, int numY, Color b, Color f)
	{
		init(w, h, numX, numY, b, f);

		add((controls = new StepControls(world)), BorderLayout.NORTH);
		add((status = new StatusWindow(new Color(0x80, 0x80, 0xff))), BorderLayout.SOUTH);

		pack();
		size = getSize(); // remember the size
	}

	public Cell [][]getGrid() { return canvas.getGrid(); }
	public int getNumX() { return canvas.getNumX(); }
	public int getNumY() { return canvas.getNumY(); }
	public void setXY(int x, int y) { canvas.setXY(x, y); }

	public void controlMessage(String msg, Color c) { controls.message(msg, c); }
	public void statusMessage(String msg) { status.print(msg); }

	// controls
	public void setRun(boolean b) { controls.setRun(b); }
	public boolean getRun() { return controls.getRun(); }
	public void setStep(int s)  { controls.setStep(s); }
	public int getStep() { return controls.getStep(); }
	public void decStep() { controls.decStep(); }
	public void setRunTime(int r) { controls.setRunTime(r); }
	public int getRunTime() { return controls.getRunTime(); }

	public void redraw() { canvas.repaint(); }

	public void paint(Graphics g)
	{
		Dimension s = getSize();
		if(s.width != size.width || s.height != size.height)
			{
			canvas.initCells();
			pack();
			size = getSize(size);	// update size
			}
	}

	public void update(Graphics g) // no need to clear screen
	{
		paint(g);
	}

	public void errorMessage(String msg)
	{
		controls.errorMessage(msg);
	}

	public static void main(String [] args)
	{
		RWFrame f = new RWFrame(600, 600, 21, 21);

		f.setTitle("Robot World");

		f.pack();

		f.setVisible(true);
	}
}
