import java.io.*; 
import java.net.*; 
import java.util.*; 
class ReadFromUrl {
	public static void main(String[] args) { 
		try {
			Scanner in = new Scanner( new InputStreamReader((new URL("http://"+args[1])).openStream())); 
			while (in.hasNextLine() && !in.hasNext("th")){
				String s = in.nextLine(); System.out.println(s);
			}
		}
		
		catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Not connected please check internet connection");
		}
	}
}
		
		
