public class Photos{
	public static void main(String [] args){
		String temp = " ";
		while(!Console.EndOfFile()){
			String stIn = Console.readToken();
			if(stIn.charAt(0)!=temp.charAt(0)){
				System.out.println("");
				System.out.println("==" + stIn.charAt(0) + "==");
			}
			if(!stIn.equalsIgnoreCase(temp)){
				System.out.println("http://www.redbrick.dcu.ie/~magluby/pics/" + stIn +".jpg " + stIn + "");
				System.out.println("");
			}	
			temp=stIn;
		}
	}
}

