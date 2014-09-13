public class NSRobot extends Robot
{
   void go()
   {
      if(!facingEast())
      { 
       turnLeft();
      }

      if(beeperPresent())
      {
         turnLeft();
      }
      if(beeperPresent())
      {
         pickBeeper();
         
         if (beeperPresent())
         {
          turnLeft();
          turnLeft();
         }
                  
      }
   }

}
