public class testBeeps
{
   public static void main(String [] args)
   {
      World testBeeps = new World();
      
      testBeeps.addBeeper(3, 9);
      testBeeps.addBeeper(3, 7);
      
      
      BeeperSeeker1 b1 = new BeeperSeeker1();
      BeeperSeeker3 b3 = new BeeperSeeker3();

      testBeeps.add(b1, 3, 9, "east");
      testBeeps.add(b3, 3, 7, "east");

      
      b1.go();
      b3.go();
   }
}
