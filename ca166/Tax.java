import java.util.*;

public class Tax{
	public static void main(String [] args){
		ConsoleReader tax = new ConsoleReader("taxpayers.txt");
		ConsoleReader un = new ConsoleReader("unemployed.txt");
		ArrayList<String> taxpayers = new ArrayList<String>();
		ArrayList<String> unemployed = new ArrayList<String>();
		ArrayList<String> dodgy = new ArrayList<String>();
		while(!tax.endOfFile()){
			String a = tax.readString();
			taxpayers.add(a);
		}
		while(!un.endOfFile()){
			String a = un.readString();
			unemployed.add(a);
		}
		for(int i = 0;i < taxpayers.size(); i++){
			if(unemployed.contains(taxpayers.get(i)))
				dodgy.add(taxpayers.get(i));
		}
		for(String num: dodgy)
			System.out.println(num);
	}
}
