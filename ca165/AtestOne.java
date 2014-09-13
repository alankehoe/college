public class AtestOne
{
	public static void main(String [] args)
	{
		int [] marks = new int[6];
		System.out.print("Enter marks:");
		for(int i = 0; i < marks.length; i++)
		{
			marks [i]=Console.readInt();
		}
	
		int max = 0;
		for(int i = 0; i < marks.length; i++)
		{
			if(marks[i] > max)
				max = marks[i];	
		}
		
		int next = 0;
		for(int i = 0; i < marks.length; i++)
		{
			if(marks[i] > next && marks[i] < max)
				next = marks[i];	
		}
		
		System.out.print(" The two best marks are "+max+" and "+next+".");
	}	
}
