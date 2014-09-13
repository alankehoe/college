public class Words{
	public static void main(String [] args){
		String [] a = new String[1000];
		System.out.println("Enter a sequence of integers ");
		int i = 0;
		while(!Console.endOfFile()){
			a[i] = Console.readToken();
			i++;
		}
		int [] nums = new int [19];
		for(int j = 0; j < i; j++){
			int i = 
