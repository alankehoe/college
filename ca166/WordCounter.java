public class WordCounter{
	public static void main(String [] args){
		int [] count = new int[30];
		for(int i = 0; i < count.length-1; i++)
			count [i] = 0;
		while(!Console.EndOfFile()){
			String w = Console.readToken();
			count[w.length()]++;
		}
		for(int i = 0; i < count.length; i++){
			if(count[i] != 0){
				System.out.println(i+" -letter words : "+count[i]);
			}
		}
	}
}
		
