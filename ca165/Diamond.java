//import robot.*;
public class Diamond
{

public static void main(String [] args)
   
   {
      World Diamond = new World();

      Diamond.addBeeper(7,3);
      Diamond.addBeeper(7,5);
      Diamond.addBeeper(7,7);
      Diamond.addBeeper(7,9);
      Diamond.addBeeper(8,4);
      Diamond.addBeeper(8,6);
      Diamond.addBeeper(8,8);
      Diamond.addBeeper(6,4);
      Diamond.addBeeper(6,6);
      Diamond.addBeeper(6,8);
      Diamond.addBeeper(9,5);
      Diamond.addBeeper(9,7);
      Diamond.addBeeper(5,5);
      Diamond.addBeeper(5,7);
      Diamond.addBeeper(4,6);
      Diamond.addBeeper(10,6);

      FourPicker alan = new FourPicker();
      Diamond.add(alan,3,6);
      
      alan.Pick4();
      
      FourPicker joe = new FourPicker();
      Diamond.add(joe,4,7);
      
      joe.Pick3();  
   }
}
