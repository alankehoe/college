import java.awt.Color;

public class Wall
{
	private int length;
	private Color c;

	public Wall() { this(1); }
	public Wall(int len ) { length = len; }

	public int getLength() { return length; }
	public Color getColor() { return c; }
}

