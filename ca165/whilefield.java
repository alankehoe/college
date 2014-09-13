public class field
{
   public static void main(String [] args)
   {
      World field = new World();

      field.addBeeper(0, 4);
      field.addBeeper(1, 4);
      field.addBeeper(2, 4);
      field.addBeeper(3, 4);
      field.addBeeper(4, 4);
      field.addBeeper(5, 4);
      field.addBeeper(6, 4);


      whileBot alan = new whileBot();
      field.add(alan, 0, 4, "east");
      
      alan.pickAll();
	

   }
}
