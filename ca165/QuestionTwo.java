import java.util.Arrays;

public class QuestionTwo
{
	public static void main(String [] args)
	{
		System.out.print("Enter a string: ");
		String [] a = new String [100];
		
		for(int i = 0; i < a.length; i++)
		{
			a[i]=Console.readString();
		}
		
		System.out.println("The tags are");
		for(int i = 0; i < a.length; i++)
		{
			if(a[i].charAt(0)=='{')
				System.out.println(a[i]);
		}
	}
}
