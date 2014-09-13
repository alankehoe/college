//
//  This class loads, and runs another class. It creates
//  the class and tries to run either start(World), start()
//  or main() in that order.

import java.lang.reflect.*;


public class AppletStart
{
	static int STARTWORLD = 0, STARTNOWORLD = 1, MAIN = 2;

	int type;
	private Method method;
	private Class c;

	AppletStart(String className) throws Exception
	{
		c = Class.forName(className);

		Class [] parameters = new Class[1];
		System.out.println("Setting up params");
		parameters[0] = Class.forName("World");

		type = STARTWORLD;

		method = getMethod("start", parameters);
		System.out.println("Method = " + method);
		if(method == null)
			{
			// try start() no params
			method = getMethod("start", new Class[0]);
			type = STARTNOWORLD;
			}

		if(method == null)
			{
			// try main
			method = getMain();
			type = MAIN;
			}

		if(method == null)
			throw new Exception("\"" + className + "\" has no public method \"start()\"");
		// At this stage we have the method and type. We're ready.
	}

	void run(Object [] args) throws Exception
	{
		Object o = c.newInstance();

		try {
			method.invoke(o, args);
			}
		catch(InvocationTargetException e)
			{ e.getTargetException().printStackTrace(); }
	}

	void run(World w) throws Exception
	{
		Object [] args;
		if(type == STARTWORLD)
			{
			args = new Object[1];
			args[0] = w;
			}
		else if(type == MAIN)
			{
			args = new Object[1];
			args[0] = new String [] {};
			}
		else if(type == STARTNOWORLD)
			args = new Object[0];
		else
			args = null;

		run(args);
	}

	private Method getMethod(String name, Class [] p)
	{
		try { return c.getMethod(name, p); }
		catch(NoSuchMethodException e) { return null; }
	}

	private Method getMain() throws Exception
	{
		Class [] parameters = new Class[1];
		parameters[0] = (new String[0]).getClass();
		try { method = c.getMethod("main", parameters); }
		catch(NoSuchMethodException e) { return null; }

		if(method != null)
			{
			// check if it's public and static
			if(method.getModifiers() != (Modifier.PUBLIC | Modifier.STATIC))
				{
				System.out.println(method.getReturnType());
				throw new Exception("main() must be public static");
				}
			else if(!method.getReturnType().toString().equals("void"))
				throw new Exception("main() must return void");
			}

		return method;
	}
}
