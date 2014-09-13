
import java.awt.*;
import java.util.Vector;

public interface RWGui
{
	void init(World world, int w, int h, int numX, int numY, Color b, Color f);

	int getNumX();
	int getNumY();

	void setXY(int x, int y);

	public void setAutomata(Vector v);
	public Vector getAutomata();


	// Message in the control window
	void controlMessage(String msg, Color c);
	// message in the status window
	void statusMessage(String msg);

	// controls
	void setRun(boolean b);
	boolean getRun();
	void setStep(int s);
	int getStep();
	void decStep();
	void setRunTime(int r);
	int getRunTime();

	void setLocation(int x, int y);
	void setVisible(boolean b);
	Dimension getSize();

	void redraw();

	Cell [][] getGrid();

	void errorMessage(String msg);
}
