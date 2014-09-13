public class Distinct{
	public static void main(String [] args){
		System.out.println("Enter a sentence and press (CTRL + D) when done :");
		String [] s = new String[1000];
		int count = 0;
		while(!Console.endOfFile()){			
			String tmp = Console.readToken();
			int i = 0;
			while(i < count && !s[i].equals(tmp)){
				i++;
			}			
			if(i == count){
				s[count] = tmp;
				count++;
			}
		}
		System.out.println(count+" Distinct words.");
	}
}
			
			
