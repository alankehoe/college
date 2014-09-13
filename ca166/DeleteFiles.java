import java.io.*;

public class DeleteFiles{
	public static void main(String[] args){ 
		for(int i = 0;i < args.length; i++){
			File gone = new File(args[i]);
			if(!gone.exists()){
				System.out.println("Cannot find file "+args[i]);
			}
			else if(gone.isDirectory()){
				System.out.println("Cannot delete directorys "+args[i]);
			}
			else{
				gone.delete();
				System.out.println(args[i]+" was deleted");
			}
		}
	}
}
		
