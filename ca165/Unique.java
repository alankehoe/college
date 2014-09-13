public class Unique
{
	static boolean isUnique(int a [])
	{
		int [] nums = a;
	
	for(int i = 0; i < nums.length; i++)
	{
		for(int j = 0; j < nums.length; j++)
		{
			//System.out.println(nums[i]+" "+nums[j]);
			if(nums[i] == nums[j] && i != j)
			{
				return false;
			}
		}
	}
	return true;	
}

		
	public static void main(String [] args)
	{
		System.out.println("How many in the array :");
		int amount = Console.readInt();
		int [] total = new int[amount];
		
		System.out.println("Enter "+ amount + " integers : ");
		for(int i = 0; i < total.length; i++)
		{
		  	total[i] = Console.readInt();
		}
	
		boolean x = isUnique(total);
		System.out.println(x);
	}
}


