import java.awt.Color;

public class Beeper
{
	private Color colour;
	public Beeper() { this(Color.blue); }
	public Beeper(Color c) { colour = c; }

	public Color getColour() { return colour; }
}

