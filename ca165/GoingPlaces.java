public class GoingPlaces
{
   public static void main(String [] args)
   {
      World stage = new World();
      Mover jim = new Mover();

      stage.add(jim);

      jim.move6();
      jim.turnLeft();
      jim.move6();

      // three turnLeft instructions to turnRight
      jim.turnLeft();
      jim.turnLeft();
      jim.turnLeft();

      jim.move6();
      jim.turnLeft();
      jim.move6();
   }
}
