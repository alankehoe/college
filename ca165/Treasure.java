public class Treasure
{
	public static void main (String [] args)
        {
	World beach = new World();
        
	beach.go(600);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	beach.addBeeper(6,8);
	
	

        beach.addBlock(6,2);
	beach.addWall(0, 9, 6, "east");
	beach.addWall(0, 10, 6, "east");
	beach.addWall(0, 11, 6, "east");
	beach.addWall(0, 12, 6, "east");
	beach.addWall(0, 13, 6, "east");
	beach.addWall(0, 14, 6, "east");

        beach.addBeeper(6,11);
	beach.addBeeper(6,11);	
	beach.addBeeper(6,11);
	beach.addBeeper(6,11);
	beach.addBeeper(6,11);
	beach.addBeeper(6,11);	
	beach.addBeeper(6,11);
	beach.addBeeper(6,11);
	beach.addBeeper(6,11);

	Blackbeard alan = new Blackbeard();
	alan.setColour("black");        
	beach.add(alan,0,0);
        
        alan.faceNorth();
        alan.findBeeps();
	alan.NSall();
        alan.findTreasure();
	alan.pickBeeps();
	}
}
