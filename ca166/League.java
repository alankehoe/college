import java.io.*;

public class League{
	public static void main(String [] args){
		try{
			RandomAccessFile f = new RandomAccessFile("league.dat","r");
			System.out.println("");
			System.out.printf("%-25s%-5s%-5s%-5s","Team","Won","Draw","Lost");System.out.println("");
			System.out.println("________________________________________");
			while(f.getFilePointer() < f.length()){
				String a = f.readUTF();
				int won = f.readInt();
				int draw = f.readInt();
				int lost = f.readInt();
				System.out.printf("%-25s%-5d%-5d%-5d",a,won,draw,lost);System.out.println("");
			}
			f.close();
		}
		catch(IOException e){
			System.out.println("cant find file");
			e.printStackTrace();
		}
	}
}
				
