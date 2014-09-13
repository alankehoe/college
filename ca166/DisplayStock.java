import java.io.*;

public class DisplayStock{
	
	static class book{
		String author,title,isbn;
		int amount;
		
		public void putStock(){
			try{
				RandomAccessFile f = new RandomAccessFile("books.dat","r");
				int i = 0;
				while(f.getFilePointer() < f.length()){
					author = f.readUTF();
					title = f.readUTF();
					isbn = f.readUTF();
					amount = f.readInt();
					System.out.printf("%-16s%-20s%-35s%-5d",isbn,author,title,amount);
					System.out.println("");
				}
			}
			catch(IOException e){
				System.out.println(":");
			}
		}
	}
	
	public static void main(String [] args){
		book [] a = new book[1000];
		//try{
		//	RandomAccessFile f = new RandomAccessFile("books.dat","r");
		//	int i = 0;
		//	while(f.getFilePointer() < f.length()){
		//		String author = f.readUTF();
		//		String title = f.readUTF();
		//		String isbn = f.readUTF();
		//		int amount = f.readInt();
		//		System.out.printf("%-16s%-20s%-35s%-5d",isbn,author,title,amount);
		//		System.out.println("");
		//	}
		//	f.close();
		//}
		//catch(IOException e){
		//	System.out.println("sdfsf");
		//}
	}
}


