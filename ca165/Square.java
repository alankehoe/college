public class Square
{
   public static void main(String [] args)
   {
      int i = 2;
      while(i >= 2 && i <= 10)
      {
         System.out.print(i);
         System.out.print(" squared is ");
         System.out.println(i * i);
         i = i + 2;
      }
   }
}
