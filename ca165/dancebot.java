public class dancebot extends Robot
{
   void toTheLeft()
   {
      move();
      move();
      turnLeft();
      move();
   }

   void toTheRight()
   {
      move();
      move();
      turnLeft();
      turnLeft();
      turnLeft();
      move();
   }
}
