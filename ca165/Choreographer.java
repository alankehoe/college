public class Choreographer
{
   public static void main(String [] args)
   {
      World danceFloor = new World();
      Dancer suzi = new Dancer();

      danceFloor.add(suzi);

      suzi.toTheLeft();
      suzi.toTheRight();
      suzi.toTheLeft();
      suzi.toTheRight();
      suzi.toTheLeft();

      // Finish with two rights
      suzi.toTheRight();
      suzi.toTheRight();
   }
}
