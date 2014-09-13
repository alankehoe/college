

public class Load
{
	// reserved classes
	static String [] reserved = {"Wall", "Cell", "Beeper", "Robot", "Automaton"
										, "World" };
   public static void main(String a[])
   {
      if(a.length != 1)
         System.out.println("Enter the name of your class");
		else
			{
			for(int i = 0; i < reserved.length; i++)
				if(reserved[i].equals(a[0]))
					{
					System.out.println('\"' + a[0] + "\" is a reserved class."
								+ " Change the name of your class to something else.");
					return;
					}
			try
				{
				Program p = new Program(a[0]);
				p.run();
				}
			catch(Exception e)
//				{ e.printStackTrace(); }
				{ System.out.println(e.getMessage()); }
			}
	}

	public void x()
	{
		System.out.println("in x");
	}
}




/*
		 Class [] parameters = new Class[0];
		 Method start = c.getMethod("start", parameters);

				 Object o = c.newInstance();
		 start.invoke(o, new Object[0]);



           Method method[] = c.getDeclaredMethods();

	    for(int i = 0; i < method.length; i++)
		"start".equals(method[i].getName())
			start = method[i];

*/