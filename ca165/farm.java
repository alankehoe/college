public class farm
{
   public static void main(String [] args)
   {
      World field = new World();

      // Add in all them beepers
      field.addBeeper(8, 4);
      field.addBeeper(8, 5);
      field.addBeeper(8, 6);
      field.addBeeper(8, 7);
      field.addBeeper(8, 8);
      field.addBeeper(8, 9);
      field.addBeeper(9, 4);
      field.addBeeper(9, 5);
      field.addBeeper(9, 6);
      field.addBeeper(9, 7);
      field.addBeeper(9, 8);
      field.addBeeper(9, 9);
      field.addBeeper(10, 4);
      field.addBeeper(10, 5);
      field.addBeeper(10, 6);
      field.addBeeper(10, 7);
      field.addBeeper(10, 8);
      field.addBeeper(10, 9);
      field.addBeeper(11, 4);
      field.addBeeper(11, 5);
      field.addBeeper(11, 6);
      field.addBeeper(11, 7);
      field.addBeeper(11, 8);
      field.addBeeper(11, 9);
      field.addBeeper(12, 4);
      field.addBeeper(12, 5);
      field.addBeeper(12, 6);
      field.addBeeper(12, 7);
      field.addBeeper(12, 8);
      field.addBeeper(12, 9);

      FarmerBot jim = new FarmerBot();
      field.add(jim, 7, 4, "east");
      
      jim.goAll();
	

   }
}
