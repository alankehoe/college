import java.util.Arrays;

public class QuestionOne
{
	public static void main (String [] args)
	{
		int [] a = new int [6];
		System.out.print("Enter marks: ");
		for(int i = 0; i < a.length; i++)
		{
			a[i] =Console.readInt();
		}
		Arrays.sort(a);
		System.out.print("The two best marks are "+a[a.length-1]+" and "+a[a.length-2]+".");
	}
}
