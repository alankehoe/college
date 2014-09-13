public class DiamondWorld
{
   public static void main(String [] args)
   {
      World field = new World();

      field.addBeeper(7,3);
      field.addBeeper(7,5);
      field.addBeeper(7,7);
      field.addBeeper(7,9);
      field.addBeeper(6,4);
      field.addBeeper(6,6);
      field.addBeeper(6,8);
      field.addBeeper(8,4);
      field.addBeeper(8,6);
      field.addBeeper(8,8);
      field.addBeeper(5,5);
      field.addBeeper(5,7);
      field.addBeeper(9,5);
      field.addBeeper(9,7);
      field.addBeeper(4,6);
      field.addBeeper(10,6);
    

      FarmerBot alan = new FarmerBot();
      field.add(alan, 6,2, "east");
      
      alan.step4();
      alan.backTrack();
      alan.step4();
      alan.backTrack();
      alan.step4();
      alan.backTrack();
      alan.step4();
    }
}
