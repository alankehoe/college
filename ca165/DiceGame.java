import graphics.*;

public class DiceGame
{
	static int roll(int high, int low) // two parameters are high and low
	{
		double random = Math.random()*10;
		int result = (int)random;
		
		while (result > high || result < low)
		{
			random = Math.random()*10; //getting a random number
			result = (int)random;      // cast it to an int
		}
		
		return result;
	}
	
	public static void main(String [] args)
	{
		System.out.println("The dice game you get ten goes at rolling the dice the aim is to get the number 2,3,11 or 12");
		int count = 1;
		for (count = 1; count < 11; count++) // this allows the user 10 trys at rolling the dice
		{	
			System.out.println("");//makes the program easier on the eye.
			System.out.println("Do you want to play the game(yes/no)??? :");//gives the option of playing or not
			String responseLine = Console.readString();
			char response = responseLine.charAt(0);
		
			if(response == 'y') // if the player wishes to play the following takes place
			{
				System.out.println("Good luck !!!");
				int once = roll(6, 1); //getting the two dice values
				int twice = roll(6, 2);
				System.out.println("first dice = " + once);
				System.out.println("second dice = " + twice);
				int num = once + twice;
				System.out.println("you rolled the number " + num + " on your " + count + " go");
			
				if (num == 2 || num == 3 || num == 11 || num == 12 )// if the result is equal to any of these you win, i have also added some code that draws one or two dice in a window if one dice is required to make the resulting number it produces a small window else it prints a big window.				
				{
					if (num == 3)
					{
						Window win = new Window(300, 300);
						Circle one = new Circle(90,90,45);
						Circle two = new Circle(150,150,45);
						Circle three = new Circle(210,210,45);
						win.fill(one);
						win.fill(two);
						win.fill(three);						
					}
					if (num == 2)
					{
						Window win = new Window(300, 300);
						Circle one = new Circle(90,90,45);
						Circle two = new Circle(210,210,45);
						win.fill(one);
						win.fill(two);
					}
					if (num == 11)
					{
						Window win = new Window(600, 300);
						Line part = new Line(300,0,300,300);
						win.draw(part);
						Circle one = new Circle(90,50,45);
						Circle two = new Circle(210,50,45);
						Circle three = new Circle(90,150,45);
						Circle four = new Circle(210,150,45);
						Circle five = new Circle(210,250,45);
						Circle six = new Circle(90,250,45);
						Circle seven = new Circle(380,50,45);
						Circle eight= new Circle(510,50,45);
						Circle nine = new Circle(380,150,45);
						Circle ten = new Circle(510,150,45);
						Circle eleven = new Circle(380,250,45);
						Circle twelve = new Circle(510,250,45);
						win.fill(one);
						win.fill(two);
						win.fill(three);
						win.fill(four);
						win.fill(five);
						win.fill(six);
						win.fill(seven);
						win.fill(eight);
						win.fill(nine);
						win.fill(ten);
						win.fill(eleven);
						
					}
					if (num == 12)
					{
						Window win = new Window(600, 300);
						Line part = new Line(300,0,300,300);
						win.draw(part);
						Circle one = new Circle(90,50,45);
						Circle two = new Circle(210,50,45);
						Circle three = new Circle(90,150,45);
						Circle four = new Circle(210,150,45);
						Circle five = new Circle(210,250,45);
						Circle six = new Circle(90,250,45);
						Circle seven = new Circle(380,50,45);
						Circle eight= new Circle(510,50,45);
						Circle nine = new Circle(380,150,45);
						Circle ten = new Circle(510,150,45);
						Circle eleven = new Circle(380,250,45);
						Circle twelve = new Circle(510,250,45);
						win.fill(one);
						win.fill(two);
						win.fill(three);
						win.fill(four);
						win.fill(five);
						win.fill(six);
						win.fill(seven);
						win.fill(eight);
						win.fill(nine);
						win.fill(ten);
						win.fill(eleven);
						win.fill(twelve);
					}
					System.out.println("You win");	
				}
			
				else 
				{
					System.out.println("you lose :");//if the result is not a winning selection
					if (count == 10)
					System.out.println("Close the graphics window to end game !");
				}		
			}

			else
			{
				System.out.println("Good bye close the graphics if any in order to use the terminal !!");//if the user does not want to play or if the ten goes are up (the close graphics window prompt is to close the program if there is any graphics windows present as i do not know any way to get it to close the window after the program has ended if you know how could you please include it in the feedback please!!!)
				break;
			}
		} 
	}
}
//i tested the program using all the different numbers as the dice result to make sure my graphics windows were correct i also tested to make sure the yes no feature is working although you can just press y or n it looks better to a user if it is yes or no, i also made sure that if you pressed no halfway through the ten goes that it would break out of the loop and end the game i provided instructions on how to get back to the terminal if there is a graphics window present.
