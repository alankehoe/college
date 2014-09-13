import java.lang.*;
import java.io.*;

public class DecimalToBinary{
	public static void main(String args[]) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the decimal value:");
   	String hex = bf.readLine();
	int i = Integer.parseInt(hex);	
	String by = Integer.toBinaryString(i);
    System.out.println("Binary: " + by);
	}
}	
