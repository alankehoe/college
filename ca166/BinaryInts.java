import java.io.*;

public class BinaryInts{
	public static void main(String [] args){
		try{
			RandomAccessFile out = new RandomAccessFile("ints.dat","rw");
			for(int i = 0; i < 50; i++){
				int k = (int)(Math.random()*20);
				out.writeInt(k);
			}
			out.close();
		}
		catch(IOException e){
			System.out.println("Couldnt write to file");
		}
	}
}
