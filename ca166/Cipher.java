public class Cipher{
	public static void main(String [] args){
		System.out.println("Enter a message to encrypt :");
		char [] alphabet ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String message;
		while(!Console.EndOfFile()){
			int j = 0;
			message = Console.readToken();
			for(int i = 0; i < alphabet.length-1; i++){
				if(message.charAt(j) == (alphabet[i])){
					System.out.print(alphabet[i+4]);
					j++;
				}
				else
					j++;
				System.out.print(" ");
			}
		}
	}
}
			
		
			
