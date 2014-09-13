public class DropWorld
{
   public static void main(String [] args)
   {
      World Drop = new World();
      
      Drop.addBeeper(3, 9);
      Drop.addBeeper(4, 9);
      
      DropBot alan = new DropBot();
      
      Drop.add(alan, 3, 9);
      alan.go();
      
   }
}
