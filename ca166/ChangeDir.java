import java.io.*;

public class ChangeDir{
	public static void main(String [] args){
		File oldfile = new File(args[0]);
		File newfile = new File(args[1]);
		if(!oldfile.exists()){
			System.out.println("cannot find "+args[0]);
		}
		
		else if(newfile.exists()){
			System.out.println(args[1]+" already exists");
		}
		
		else{		
			oldfile.renameTo(newfile);
			System.out.println("Done");
		}
	}
}

				
