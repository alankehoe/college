public class Grep{
	public static void main(String [] args){
		String a = args[0];
		String [] all = new String[1000];
		int i = 0;
		//System.out.println("enter some txt");
		while(!Console.endOfFile()){
			all[i] = Console.readString();
			i++;
		}
		for(int j = 0; j < i; j++){
			if(all[j].contains(a))
				System.out.println(all[j]);
		}
		
	}
}
	
			

