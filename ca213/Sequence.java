public class Sequence{
	public static void main(String [] args){
		System.out.println("Enter a Sequence of numbers and press \"ctrl+D\" to finish");
		int [] a = new int[1000];
		int i = 0;
		while(!Console.endOfFile()){
			a[i] = Console.readInt();
			i++;
		}
		int max = a[0];
		for(int j = 1; j < i; j++){
			if(a[j] > max)
				max = a[j];
		}
		System.out.println("largest number is "+max);
	}
}
			
