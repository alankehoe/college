import java.io.*;

public class Membership{
	public static void main(String [] args){
		final int firstMem = 1000;
		final int nameLen = 40;
		final int recSize = (2+nameLen)+2+4;
		try{
			RandomAccessFile f = new RandomAccessFile("Members.dat","rw");
			int nextNum = firstMem+(int)(f.length()/recSize);
			while(!Console.endOfFile()){
				String token = Console.readToken();
				if(Character.isDigit(token.charAt(0))){ //query
					int num = Integer.parseInt(token);
					if(num < firstMem || num >= nextNum)
						System.out.println("Not a member");
					else{
						int offset = (num-firstMem)*recSize;
						f.seek(offset);
						String name = (f.readUTF()).trim();
						char sport = f.readChar();
						System.out.print(name+"(");
						if(sport == 't')
							System.out.print("tennis");
						else
							System.out.print("squash");
						System.out.println(")");
					}
				}
				else{ //new member
					String name = token +" "+Console.readToken();
					char sport = (Console.readToken()).charAt(0);
					int num = nextNum;
					nextNum++;
					f.seek(f.length());
					f.writeUTF(String.format("-"+nameLen+"s"));
					f.writeChar(sport);
					f.writeInt(num);
					System.out.println("membership number: "+num);
				}
			}
			//f.close();
		}
		catch(IOException e){
			System.out.println("Couldnt access file");
		}
	}
}
	
					
