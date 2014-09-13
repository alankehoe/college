public class whileBot extends Robot
{
   void pickAll()
   {
   while(beeperPresent())
      pickBeeper();
      move();
   }
}
