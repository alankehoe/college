public class Runner extends Robot
{
   void goTilBlocked()
   {
      while(frontIsClear())
         move();
   }
}

