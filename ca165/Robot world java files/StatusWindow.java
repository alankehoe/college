import java.awt.*;

class StatusWindow extends Canvas
{
	static int FONTSIZE=16;
	static int BORDER=FONTSIZE/5+2;
	String message;
	int yPos;

	private static Color defaultBackColour = new Color(0xe0, 0xe0, 0xe0);
	static void setDefaultBackColour(Color c) { defaultBackColour = c; }

	StatusWindow()
	{
		this(defaultBackColour);
	}

	StatusWindow(Color c)
	{
		FontMetrics fm = getFontMetrics(new Font("sans serif", Font.BOLD, FONTSIZE));
		int ascent = fm.getAscent();
		int height = fm.getHeight();

		setSize(30, height + 2 * BORDER);

		yPos = ascent + BORDER;

		message = "";
		setBackground(c);
	}

	public void paint(Graphics g)
	{
		Dimension s = getSize();
		g.setFont(new Font("sans serif", Font.BOLD, FONTSIZE));
		g.drawString(message, 4, yPos);
		g.drawRect(0, 0, s.width - 1, s.height - 1);
	}

	void print(String s)
	{
//		System.out.println("m = " + s);
		message = s;
		repaint();
	}

	public static void main(String [] args)
	{
		// Want a label in a panel in a frame.
		Frame w = new ClosableFrame("Status Test");
		w.setLayout(new BorderLayout());

		StatusWindow status = new StatusWindow();
		w.add(status);

		w.pack();
		w.setVisible(true);

		status.print("x = " + (4 * 3));
		status.print("MWghIjk|");
		status.repaint();
	}
}

