public class Sums{
	static int sumFac(int n){
		int sum = 0;
		for(int i = 1; i < n; i++){
			if(n % i == 0){
				sum = sum + i;
			}
		}
		return sum;
	}
	
	static boolean isPerfect(int n){
		if(sumFac(n) == n)
			return true;
		else
			return false;
	}
			
			
	public static void main(String [] args){
		boolean perfect;
		while(!Console.EndOfFile()){
			int num = Console.readInt();
			perfect = isPerfect(num);
			if (perfect == true){
				System.out.println("is perfect");
				num = Console.readInt();
			}
			if (perfect == false){
				System.out.println("not perfect");
				num = Console.readInt();
			}
		}
			
	}
		
}
