public class LongWords{
	public static void main(String [] args){
		ConsoleReader a = new ConsoleReader(args[0]);
		String [] b = new String[10000];
		int total = 0;
		int i = 0;
		while(!a.endOfFile()){
			b[i] = a.readToken();
			total = total + b[i].length();
			i++;
		}
		int avg = total / i;
		for(int j = 0; j < i; j++){
			if(b[j].length() > avg)
				System.out.println(b[j]);
		}
	}
}
