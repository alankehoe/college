public class Blackbeard extends Robot
{
	void findBeeps()
	{
        	{
		while (frontIsClear())
			move();
		}
		{
		while (!facingEast())
                	turnLeft();                        
		}
		{
		while(!beeperPresent())
			move();
		}	
	}

	void pickBeeps()
	{
		{
		while (beeperPresent())
			pickBeeper();
		}	
	}

	void faceNorth()
	{
		{
    		while(!facingNorth())
			turnLeft();
		}	
	}
        
	void findTreasure()
	{
		{
		while(!beeperPresent())
			move();
		}
	}

	void Npick()
	{
		{
		if(beeperPresent())
			pickBeeper();
			faceNorth();
		}		
	}

	void Spick()
	{
		{
		if(beeperPresent())
			pickBeeper();
			faceSouth();
		}
	}

	void faceSouth()
	{
		{
		while(!facingSouth())
			turnLeft();
		}
	}
	
	void NS()
	{
		{
		if(beeperPresent())
			Spick();
			Npick();
		}
	}

	void NSall()
	{
		{
		while(beeperPresent())
			NS();
		}
	}
}
