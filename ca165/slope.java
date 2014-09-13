public class slope
{
   public static void main(String [] args)
   {
      System.out.println("Input x coordinate of the first point:");
      double x1 = Console.readDouble();

      System.out.println("Input y coordinate of the first point:");
      double y1 = Console.readDouble();

      System.out.println("Input x coordinate of the second point:");
      double x2 = Console.readDouble();

      System.out.println("Input y coordinate of the second point:");
      double y2 = Console.readDouble();

      double slope = (y2 - y1) / (x2 - x1);
      
      if (x1 == x2)
      {
      	System.out.println("cannot calculate verticle slope");
      }
      else

      System.out.println("The slope of the line between Points 1 and 2 is " + slope);
      
      
   }
}

