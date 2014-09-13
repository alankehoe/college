public abstract class Automaton extends Robot implements Runnable
{
	protected boolean finished;

	boolean finished() { return finished; }

	Automaton()
	{
		finished = false;
	}

	abstract void go();

	public void move()
	{
		sync();
		super.move();
	}

	public void turnLeft()
	{
		sync();
		super.turnLeft();
	}

	public void pickBeeper()
	{
		sync();
		super.pickBeeper();
	}

	public void putBeeper()
	{
		sync();
		super.putBeeper();
	}

	// Wait 'til notified by world
	synchronized void sync()
	{
//		System.out.print("Auto wait ... ");
		try {
			wait();
			}
		catch(InterruptedException e) {}
//		System.out.println("... unwait");
	}

	final public void run()
	{
		go();
		finished = true;
	}
}
