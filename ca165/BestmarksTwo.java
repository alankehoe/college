import java.util.Arrays;

public class BestmarksTwo
{
	public static void main(String [] args)
	{
		System.out.println("How many marks :");
		int a = Console.readInt();
		System.out.println("Enter the results :");
		int [] marks = new int [a];
		long start = 0;
		long stop = 0;
		start = System.currentTimeMillis();
		
		for(int i = 0; i < marks.length; i++)
		{
			marks[i]=Console.readInt();
			if(i == marks.length-1)
				stop = System.currentTimeMillis();
		}
		Arrays.sort(marks);
		System.out.println("It took you "+(stop-start)+" milliseconds to enter the marks");
		System.out.println("");
		System.out.println("The best marks were "+marks[marks.length-1]+" and "+marks[marks.length-2]);
	}
}
