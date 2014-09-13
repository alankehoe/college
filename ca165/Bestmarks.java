public class Bestmarks
{
	public static void main(String [] args)
	{
		System.out.println("How many marks : ");
		int amount =Console.readInt();
		int [] marks = new int [amount];
		System.out.println("Enter the marks : ");
		
		for(int i = 0; i < marks.length; i++)
		{
			marks[i]=Console.readInt();
		}
		int max = 0;
		int next = 0;
		
		for(int i = 0; i < marks.length; i++)
		{
			if(marks[i] > max)
				max = marks[i];
		}
		
		for(int i = 0; i < marks.length; i++)
		{
			if(marks[i] > next && marks[i] < max)
				next = marks[i];
		} 
		
		int maxtmp = 0;
		int nexttmp = 0;
		for(int i = 0; i < marks.length; i++)
		{
			if(marks[i] == max)
				maxtmp = i;
				
			if(marks[i] == next && marks[i] < max)
				nexttmp = i;
		}
		System.out.println("the best marks were "+max+" and "+next);
		System.out.println(" max was at index: "+maxtmp);
		System.out.println(" max was at index: "+nexttmp);
		
	}
}
