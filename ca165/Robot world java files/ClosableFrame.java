
import java.awt.*;
import java.awt.event.*;

public class ClosableFrame extends Frame
{
	ClosableFrame(String s)
	{
		super(s);
		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e) { System.exit(0); }
			}
		);
	}

	ClosableFrame()
	{
		this(null);
	}
}