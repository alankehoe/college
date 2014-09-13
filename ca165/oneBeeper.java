public class oneBeeper
{
  public static void main (String [] args)
  {
     World space = new World();
     space.addBeeper (5,2);
     space.addBeeper(0,0);
     space.addBeeper(14,14);
     space.addBeeper(0,14);
     space.addBeeper(14,0);
     space.addRobot(0,0);
  }
}
