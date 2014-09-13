public class Verbalise{
	static void putVerbal(int n){
		String [] digit = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		if(n < 10)
			System.out.print(digit[n]+" ");
		else{
			putVerbal(n/10);
			putVerbal(n%10);
		}
	}
	public static void main(String [] args){
		while(!Console.endOfFile()){
			int i = Console.readInt();
			putVerbal(i);
			System.out.println("");
		}
	}
}	
