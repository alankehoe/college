public class ifWorld
{
   public static void main (String [] args)
   {
      World ifWorld = new World();
      ifRobot alan = new ifRobot();

      ifWorld.add(alan,6,6);
      alan.go();
      alan.turnLeft();
      
      ifWorld.addWall(2,5,3,"East");
      ifWorld.addBeeper(6,6);
      ifWorld.addBeeper(9,10);
    
   }
}
