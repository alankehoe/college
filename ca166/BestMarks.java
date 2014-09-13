class BestMarks
{
	public static void main(String[] args) 
	{
		int m;
		String s;
		int bestMark = -1; // Best mark seen so far
		String bestStudent = ""; // Name of best student so far.
		//Read student data
		while (!Console.EndOfFile()) 
		{
			m = Console.readInt();  s = Console.readString();
			// Is this student the best so far?
			if (m>bestMark) 
			{  // Yes, so note the details
				bestMark = m;  bestStudent = s;
			}
		}
		// Print result
		System.out.println("The best student is " + bestStudent + 
					" who scored " + bestMark + " marks.");
	}
}
