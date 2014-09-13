public class SortReverse
{
   private static void swap(int [] num, int i, int j)
   {
      int tmp = num[i];
      num[i] = num[j];
      num[j] = tmp;
   }

   public static void sort(int [] num)
   {
      for(int i = 0; i < num.length - 1; i++)
      {
         // First find the index of the smallest element
         int minIndex = i;
         for(int j = i + 1; j < num.length; j++)
            if(num[j] < num[minIndex])
               minIndex = j;

         // Swap the smallest with the current position
         swap(num, i, minIndex);
      }
   }

   public static void main(String [] args)
   {
      // define the array to be sorted
      int [] num = {25, 82, 38, 40, 2, 77, 65};

      // Print the unsorted array
      System.out.println("The unsorted array:");
      for(int i = 0; i < num.length; i++)
         System.out.print(num[i] + " ");
      System.out.println();

      // Call the sort method ...
      sort(num);

      // the array is now sorted ... print it out
      System.out.println();
      System.out.println("The sorted array:");
      for(int i = 0; i < num.length; i++)
         System.out.print(num[i] + " ");
   }
}
