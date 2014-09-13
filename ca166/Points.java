import java.io.*;

public class Points{
	public static void main(String [] args){
		try{
			RandomAccessFile in = new RandomAccessFile("league.dat","r");
			RandomAccessFile out = new RandomAccessFile("points.dat","rw");
			while(in.getFilePointer() < in.length()){
				String team = in.readUTF();
				int total = in.readInt()*3+in.readInt()*1+in.readInt()*0;
				String.format("30-s",team);
				out.writeUTF(team);
				out.writeInt(total);
				//System.out.printf("%-30s%-4d",team,total);
				//System.out.println("");
			}
			in.close();
			out.close();
		}
		catch(IOException e){
			System.out.println("Cant read file league.dat");
			e.printStackTrace();
		}
	}
}
