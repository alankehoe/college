public class ifRobot extends Robot
{
   void go()
   {
      if(beeperPresent())
      {
         pickBeeper();
         move();
      }
      else
      {
         turnLeft();
         move();
      }
   }
   void move5()
   {
      move();
      move();
      move();
      move();
      move();
   }
   void pick5()
   {
      move();
      pickBeeper();
      move();
      pickBeeper();
      move();
      pickBeeper();
      move();
      pickBeeper();
      move();
      pickBeeper();
   }   
   void turnRight()
   {
      turnLeft();
      turnLeft();
      turnLeft();
   }
}
