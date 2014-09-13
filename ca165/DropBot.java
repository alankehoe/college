public class DropBot extends Robot
{
   void DropAll()
   {
      while(!frontIsClear())
	{
        	putBeeper();
	}        
   }
   
   void PickMove()
   {
      while(beeperPresent())
        {
		pickBeeper();
        	move();
        }
   }
   void go()
   {
       PickMove();
       DropAll();
   }
}
