public class Farmer extends Robot
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
   
   void newRow()
   {
      turnLeft();
      move();
      turnLeft();
      move5();
      turnAround();   
   }
   
   void move5()
   {
      move();
      move();
      move();
      move();
      move();
   }
   
   void turnAround()
   {
      turnLeft();
      turnLeft();
   }
   
   void PickAll()
   {
      pick5();
      newRow();
      pick5();
      newRow();
      pick5();
      newRow();
      pick5();
      newRow();
      pick5();
      newRow();
      pick5();
      newRow();
   }
}
