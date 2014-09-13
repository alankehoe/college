public class NSBeepers
{
   public static void main(String [] args)
   {
      World NS = new World();
      
      NS.addBeeper(3, 9);
      NS.addBeeper(3, 7);
      NS.addBeeper(3, 7);
      
      
      NSRobot a = new NSRobot();
      NSRobot b = new NSRobot();

      NS.add(a, 3, 9, "west");
      NS.add(b, 3, 7, "east");

      
      a.go();
      b.go();
   }
}
