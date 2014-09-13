public class ConsoleSquares
{
   public static void main(String [] args)
   {
      System.out.println("enter a number");  
      int i = Console.readInt();
      while(i >= 1)
      {
         System.out.print(i);
         System.out.print(" squared is ");
         System.out.println(i * i);
         i = i - 1;
      }
   }
}
