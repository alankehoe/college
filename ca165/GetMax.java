public class GetMax
{	
	public static void main(String [] args)
	{
		System.out.println("How long do you want the array to be : ");
		int a =Console.readInt();
		int [] numbers = new int[a];
		System.out.println("Enter " +a+ " numbers");
 		
		for(int i = 0; i < numbers.length; i++)
		{
        		numbers[i] = Console.readInt();
        	}
	}	
}
