import java.io.*;

public class CountInts{
	public static void main(String [] args){
		try{
			RandomAccessFile f = new RandomAccessFile("ints.dat","r");
			int count = 0;
			while(f.getFilePointer()<f.length()){
				count = count + f.readInt();
			}
			System.out.println(count);
		}
		catch(IOException e){
			System.out.println("Cant read file");
			e.printStackTrace();
		}
	}
}
				
