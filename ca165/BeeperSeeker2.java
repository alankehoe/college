public class BeeperSeeker2 extends Robot
{
   void go()
   {
      if(!beeperPresent())
      {
         move();
      }
      if(beeperPresent())
      {
         pickBeeper();
      }
   }
}
