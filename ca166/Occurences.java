import java.util.*;

public class Occurences{
	public static void main(String [] args){
		ArrayList<String> a = new ArrayList<String>();
		String word = "";
		int times = -1;
		while(!Console.endOfFile()){
			word = Console.readToken();
			a.add(word);
			for(int i = 0;i < a.size(); i++){
				if(a.get(i).equals(word)){
					times++;
				}
			}
			System.out.println(times+" previous occurences");
			times = -1;
		}
	}
}

