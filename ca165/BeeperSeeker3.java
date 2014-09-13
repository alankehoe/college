public class BeeperSeeker3 extends Robot
{
   void go()
   {
      if(beeperPresent())
      {
         pickBeeper();
      }
      if(!beeperPresent())
      {
         move();
      }
   }
}
