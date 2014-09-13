public class Mystery
{
   public static void main(String [] args)
   {
      World eerie = new World();
      Robot x = new Robot();

      eerie.addWall(5, 3, 3, "north");
      eerie.addWall(7, 3, 2, "north");
      eerie.addBlock(6, 3);
      eerie.addBeeper(6, 4);

      eerie.add(x);

      x.move();
      x.move();
      x.move();
      x.move();
      x.turnLeft();
      x.move();
      x.move();
      x.move();
      x.move();
      x.move();
      x.move();
      x.turnLeft();
      x.turnLeft();
      x.turnLeft();
      x.move();
      x.move();
      x.turnLeft();
      x.turnLeft();
      x.turnLeft();
      x.move();
      x.move();
      x.pickBeeper();
      x.turnLeft();
      x.turnLeft();
      x.move();
      x.move();
      x.turnLeft();
      x.move();
      x.move();
      x.move();
      x.move();
      x.turnLeft();
      x.move();
      x.move();
      x.move();
      x.move();
      x.move();
      x.putBeeper();
   }
}
