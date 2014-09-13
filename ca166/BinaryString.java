import java.io.*;

public class BinaryString{
	public static void main(String [] args){
		try{
			RandomAccessFile out = new RandomAccessFile(args[0],"rw");
			while(!Console.endOfFile()){
				String tmp = Console.readString();
				out.writeUTF(tmp);
			}
			out.close();
		}
		catch(IOException e){
			System.out.println("Cant write to file");
		}
	}
}
			
		
