public class BinSortStrings
{
	public static int search(String [] a, String x)
	   {
	      int low = 0;
	      int hi = a.length - 1;
	      int index = -1;
	      while(low <= hi)
	      {
		 int mid = (low + hi) / 2;
		 if(x.compareTo(a[mid]) < 0)
		    hi = mid - 1; // to the right
		 else if( x.compareTo(a[mid]) > 0)
		    low = mid + 1; // to the left
		 else
		 {
		    // Neither greater than nor less than ...
		    // ... must be equal
		   //System.out.println("hello");
		    index = mid; // a[mid] is our guy, set index to mid
		    break;
		 }
	      }
	
	      return index;
	   }
	private static void swap(String [] num , int i, int j)
	   {
	      String tmp = num[i];
	      num[i] = num[j];
	      num[j] = tmp;
	   }
	
	   public static void sort(String [] s)
	   {
	      int x = s.length;
	      for(int i = 0; i < x - 1; i++)
	      {
		 // First find the index of the smallest element
		 int maxIndex = i;
		 for(int j = i + 1; j < x; j++)
		    if(s[j].compareTo(s[maxIndex]) <= 0)
		       maxIndex = j;
	
		 // Swap the smallest with the current position
		 swap(s, i, maxIndex);
	      }
	   }
	public static void main(String [] args)
	{
		System.out.println("How many Strings?");
		int x = Console.readInt();
		String [] array = new String [x];
		System.out.println("enter " + x + " Strings: ");
		for(int i = 0; i < x; i ++)
		{
			array[i] = Console.readString();
		}
		sort(array);
		System.out.println("");
		for(int i = 0; i < x; i ++)
		{
			System.out.println(i+")	"+array[i]);
		}
		System.out.println("enter a word:");
		String y = Console.readString();

		System.out.println(y + " is at index ");
		System.out.println(search(array, y));
	}	
}
