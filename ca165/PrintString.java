// Program to create a String of at least 10 '-'s
public class PrintString
{
   public static void main(String [] args)
   {
      String data;

      // Put one "-" in data
      data = "-";
      // Keep going as long as the length is less than 10
      while(data.length() < 10)
      {
         // Plonk an "-" onto the end of the string
         data = data + "-";
      }

      System.out.println(data);
   }
}
