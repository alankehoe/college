public class CleverRobot extends Robot
{
   void movePick()
   {
    move();
    pickBeeper();
   }

   void pick5()
   {
     movePick();
     movePick();
     movePick();
     movePick();
     movePick();
   }
}
