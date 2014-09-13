import java.lang.reflect.*;
import java.util.StringTokenizer;

public class Program
{
	private Method method;
	private Object [] args;
	private Class c;

	// This constructor fills method and args from 'line'
	// e.g. 'Robot.meth1' yields the method '(new Robot()).start()'
	//      'robot' yields the method 'Robot.main(String [] args)'
	//					or '(new Robot()).start()' if there is no main()
	Program(String line) throws Exception
	{
		// find if the class has a start method
		StringTokenizer st = new StringTokenizer(line, ".");

		int numTokens = st.countTokens();

		String className = st.nextToken();

		c = Class.forName(className);

/*		Method [] m = c.getMethods();
		for(int i = 0; i < m.length; i++)
			System.out.println(m[i]);*/

		String methodName = "start";

		args = new Object[0];
		if(numTokens == 2)
			{
			methodName = st.nextToken();
			method = getMethod(methodName);
			}
		else
			{
			method = getMain();

			if(method != null)
				{
				// Set up the arguments (String array)
				args = new Object[1];
				args[0] = new String [] {};
				}
			else
				method = getMethod(methodName);
			}

		if(method == null)
			throw new Exception("\"" + className + "\" has no public method \"" + methodName + "()\"");
		// At this stage we have the method and args. We're ready.
	}

	void run() throws Exception
	{
//		System.out.println("run(), method = " + method);
		Object o = c.newInstance();
//		System.out.println("o = " + o.toString());
		method.invoke(o, args);
//		System.out.println("invoked, args = " + args);
	}

	private Method getMethod(String name)
	{
		try { return c.getMethod(name, new Class[0]); }
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
