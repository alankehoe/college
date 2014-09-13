public class CleverWorld
{
   public static void main(String [] args)
   {
      World Clever = new World();
      CleverRobot suzi = new CleverRobot();

      Clever.add(suzi);
      suzi.move5();
      suzi.move5();
      suzi.turnLeft();
      suzi.move5();
      suzi.turnAround();
      suzi.move5();
      suzi.turnLeft();
      suzi.turnLeft();
      suzi.turnLeft();
      suzi.move5();
      suzi.move5();
   }
}
