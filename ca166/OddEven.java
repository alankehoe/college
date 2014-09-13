import java.util.*;

public class OddEven{
	public static void main(String [] args){
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		while(!Console.endOfFile()){
			int a = Console.readInt();
			if(a % 2 == 0)
				even.add(a);
			else	
				odd.add(a);
		}
		for (Integer a: even){
			System.out.print(a + " ");
		}
		System.out.println("");
		for (Integer a: odd){
			System.out.print(a + " ");
		}
		System.out.println("");
	}
}
		
			
