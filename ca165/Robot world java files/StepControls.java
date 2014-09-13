
import java.awt.*;
import java.awt.event.*;

class StepControls extends Panel
{
	World world;
	TextField textF;
   Button runButton;
   Button stepButton;
//   Button restartButton;

	private static Color defaultBackColour = new Color(0xe0, 0xe0, 0xe0);
	static void setDefaultBackColour(Color c) { defaultBackColour = c; }

   private String error;

	private boolean run;
	private int step;
	private int runTime;

	void setRun(boolean b) { run = b; }
	boolean getRun() { return run; }
	void setStep(int s)  { step = s; }
	int getStep() { return step; }
	void decStep() { if(step > 0) step--; }
	void setRunTime(int r) { runTime = r; textF.setText(""+runTime); }
	int getRunTime() { return runTime; }

   public StepControls(World w)
	{
		world = w;
		error = null;
		run = false;
		step = 0;
		runTime = 300;

		setBackground(defaultBackColour);

		add(stepButton = new Button("Step"));
		add(runButton = new Button("Run"));
		add(textF = new TextField("" + runTime,4));

		stepButton.addActionListener(new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{
					run = false; // when step button pressed, stop running.
					synchronized(world) { world.notify(); };
				}
			});
		runButton.addActionListener(new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{
					run = !run; // Toggle the run state
					synchronized(world) { world.notify(); }
				}
			});

		textF.addTextListener(new TextListener()
			{	public void textValueChanged(TextEvent e)
				{
					int i = runTime;
					try {
						i = Integer.parseInt(textF.getText().trim());
					} catch(Exception ex) {textF.setText(""+i);}

					if(i != runTime)
						runTime = i;
				}
			});
	}

	void errorMessage(String msg)
	{
		message(msg, Color.red);
	}

	void message(String msg, Color c)
	{
		// work out the size of the message
		Dimension size = getSize();

//		remove(restartButton);
/*		remove(runButton);
		remove(stepButton);
		remove(textF);*/

		// Get anything on the screen.
		Component [] comps = getComponents();
		for(int i = 0; i < comps.length; i++)
			remove(comps[i]); // ... remove it

		FontMetrics fm = getFontMetrics(new Font("sans serif", Font.BOLD, 16));
		int len = fm.stringWidth(msg) + 20;
		if(len > size.width)
			size.width = len;

		// Change the borders of the layout manager to zero
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		ControlMessage m = new ControlMessage(msg, size, c); // specify the size

		add(m);

		m.repaint();
	}

	public static void main(String [] a)
	{
		Frame f = new ClosableFrame();
		StepControls c = new StepControls(null);
		f.add(c);
		f.pack();
		f.setVisible(true);
		c.errorMessage("Test");
	}
}

class ControlMessage extends Canvas
{
	String message;
	ControlMessage(String msg, Dimension size, Color c)
	{
		message = msg;
		setSize(size);
		setBackground(c);
	}

	ControlMessage(String msg, Dimension size)
	{
		this(msg, size, Color.red);
	}

	public void paint(Graphics g)
	{
		Dimension s = getSize();
		g.setFont(new Font("sans serif", Font.BOLD, 16));
		Util.centreText(message, g, Color.black, 0, 0, s.width, s.height);
		g.drawRect(0, 0, s.width - 1, s.height - 1);
	}
}

