public class TestSum
{
	static int sum(int [] numbers)
        {
        int sum = numbers [0];
        for(int i = 1; i < numbers.length; i++)
        	sum = numbers[i] + sum;
        return sum;
        }

	public static void main(String [] args)
	{
		int [] nums1 = {1, 10, 20};
		int sum1 = sum(nums1);

		System.out.println("The total of all the elements of nums1 is " + sum1);

		int [] nums2 = {1, 0, 0, 2, 3, 4};
		int sum2 = sum(nums2);

		System.out.println("The total of all the elements of nums2 is " + sum2);
	}
}
