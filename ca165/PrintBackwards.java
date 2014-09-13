public class PrintBackwards
{
   public static void main(String [] args)
   {
      int i = 10;
      while(i >= 1)
      {
         System.out.print(i);
         System.out.print(" squared is ");
         System.out.println(i * i);
         i = i - 1;
      }
   }
}
