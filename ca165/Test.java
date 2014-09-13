public class Test
{
   public static void main(String [] args)
   {
      String word = Console.readToken();
      while(word != null)
      {
         // deal with the word
         System.out.println(":" + word + ":");

         // read in the next word
         word = Console.readToken();
      }
   }
}
