// the following source code is a program that asks a user to enter a number between 1 and 1000, the program generates a random double between 0.0 and 1.0 this is then multiplied by 1000 and converted to an integer to satisfy the between 1 and 1000 statment, the user enters a number the program then checks to see if the number is equal to less than or more than the random number, if it is more it says "lower" if lower it says " higher ". there are only ten chances to get the correct anwser after which the program will end and say "you lose", however if the correct number is guessed before ten trys are up, the program will end and display "you got it" if you enter a higher value than 1000 the program will end automaticaly. it will then calculate how many gueses it took you to get the right anwser considering you got the right anwser.

public class Random
{
	public static void main (String [] args)
	{
		System.out.println("Plese enter an integer between 1 and 1000, You have ten trys !!!");
		
		int i = 0;
		double b = Math.random() * 1000;
		int a = (int) b; // this method assigns double b to an integer.
		
		//System.out.println(a + " Is the number we are trying to find !! "); // just for testing the program originally //

// Within the following while statement the "one ++" controls the amount of goes the user gets and the "break " command exits the program if the conditions in the brackets are met. after the loop ends there is one condition to be met (i = a) if this is false it goes to the "else statement" which can only mean that you lost. 
		
		int count = 0;
		while (i != a && count < 10)
		{	
		        count ++;
		        i = Console.readInt();
		        
			if (i == a || count > 10)
				break;	

			if (i > 1000)
			{
				break;
			}
				
			else if (i < a)
			{
				System.out.println("Higher");
			}
		
			else if (i > a)
			{
				System.out.println("Lower");
			}
		}
				
		if (i == a)
		{ 
			System.out.println("You got it on your " + count + " go !!!");
		}
		
		else  
		{
			System.out.println("You lose !!");
		}
	}
}
//i tested this program continously i printed "a" during my testing to make sure everything was working fine you can check this aswell if you erase the comment tag from the System.out.println (a); you can then see the anwser while you are testing it to make sure everything is working perfectly.
		
