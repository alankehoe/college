public class BeeperSeeker1 extends Robot
{
   void go()
   {
      if(!beeperPresent())
      {
         move();
      }
      else
      {
         pickBeeper();
      }
   }
}
