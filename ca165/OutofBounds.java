public class OutofBounds
{	
	public static void main (String [] args)
	{
	        int primes = new int[20];
	        for(int i = 0; i < primes.length; i++)
	        {
	        	primes[i] = i;
	        }
	        System.out.println(primes[0] + primes[primes.length]);		
	}
}
