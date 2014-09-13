public class BinSearch
{
   public static int search(int [] a, int x)
   {
      int low = 0;
      int hi = a.length - 1;
      int index = -1;
      while(low <= hi)
      {
         int mid = (low + hi) / 2;
         if(x < a[mid])
            hi = mid - 1; // to the right
         else if( x > a[mid])
            low = mid + 1; // to the left
         else
         {
            // Neither greater than nor less than ...
            // ... must be equal
            index = mid; // a[mid] is our guy, set index to mid
            break;
         }
      }

      return index;
   }

   public static void main(String [] args)
   {
      // define an integer array
      int [] num = {25, 82, 38, 40, 2, 77, 65};

      System.out.println("The unsorted array:");
      for(int i = 0; i < num.length; i = i + 1)
         System.out.print(num[i] + " ");
      System.out.println("\n");

      // Call the sort method (static method of the Sort class)
      Sort.sort(num);

      System.out.println("The sorted array:");
      for(int i = 0; i < num.length; i = i + 1)
         System.out.print(num[i] + " ");
      System.out.println("\n");

      System.out.println("enter a number:");
      int x = Console.readInt();

      System.out.println(x + " is at index ");
      System.out.println(search(num, x));
   }
}
