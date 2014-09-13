public class FarmerBot extends Robot
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
   void move5()
   {
      move();
      move();
      move();
      move();
      move();
   }
   void reposition()
   {
      turnLeft();
      move();
      turnLeft();
      move5();
      turnAround();
   }
   void turnAround()
   {
      turnLeft();
      turnLeft();
   }
   void go()
   {
      pick5();
      reposition();
   }
   void goAll()
   {
      go();
      go();
      go();
      go();
      go();
      go();
   }
   void stepPick()
   {
     turnLeft();
     move();
     turnRight();
     move();
     pickBeeper();
   }
   void turnRight()
   {
     turnLeft();
     turnLeft();
     turnLeft();
   }
   void step4()
   {
     stepPick();
     stepPick();
     stepPick();
     stepPick();
   }
   void backTrack()
   {
    turnAround();
    move5();
    turnLeft();
    move3();
    turnLeft();
   }
   void move3()
   {
    move();
    move();
    move();
   }
}
