import java.io.*; 
import java.net.*; 
import java.util.*; 
class Currency{
	public static int Convert(int a, int b){
		return a*b;
	}
	
	public static void main(String[] args){ 
		try{
			Scanner in = new Scanner( new InputStreamReader((new URL("http://www.ecb.int/stats/exchange/eurofxref/html/index.en.html").openStream()))); 
			while (in.hasNextLine() && !in.next().equals("<td headers=\"aa\"")){
				String s = in.nextLine(); 
				System.out.println(s);
			}
		}
		
		catch (IOException e){
			//e.printStackTrace();
			System.out.println("Not connected please check internet connection");
		}
	}
}
		
		
