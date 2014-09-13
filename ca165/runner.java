public class runner extends Robot
{
   void goTilBlocked()
   {
      while(frontIsClear())
         move();
   }
}

