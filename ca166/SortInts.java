import java.util.*;

public class SortInts{
	public static void main(String [] args){
		ArrayList<Integer> ints = new ArrayList<Integer>();
		while(!Console.endOfFile()){
			int a = Console.readInt();
			ints.add(a);
		}
		Collections.sort(ints);
		for (Integer a: ints) {
			System.out.print(a + " ");
		}
	}
}
		
			
