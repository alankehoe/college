import java.io.*;
import java.util.*;

public class Q3e9{
	public static void main(String [] args){
		try{
			Scanner in = new Scanner(new File(args[0]));Scanner in2 = new Scanner(new File(args[1]));
			PrintWriter out = new PrintWriter(args[2]);
			
			while(in.hasNext()){
				out.println(in.nextLine());
			}
			out.println("");
			
			while(in2.hasNext()){
				out.println(in2.nextLine());
			}
			in.close();in2.close();out.close();
		}
		catch(IOException e){
			System.out.println("fail");
			e.printStackTrace();
		}
	}
}
			
