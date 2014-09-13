public class FourPicker extends Robot
{
   void Pick4()
   {
    move();
    pickBeeper();
    move2();
    pickBeeper();
    move2();
    pickBeeper();
    move2();
    pickBeeper();
    move2();
   }

   void Pick3()
   {
    move();
    pickBeeper();
    move2();
    pickBeeper();
    move2();
    pickBeeper();
    move2();
   }

   void Pick2()
   {
    move();
    pickBeeper();
    move2();
    pickBeeper();
    move2();
   }
  
   void Pick1()
   {
    move();
    pickBeeper();
    move2();
   }
   
   void move2()
   {
    move();
    move();
   }
 
}
