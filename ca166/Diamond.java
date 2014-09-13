public class Diamond{
	public static void main (String [] args){
		System.out.println("Enter a number :");
		int count = Console.readInt();
		int steps = count;
		for(int i = 0; i < count; i++){
			for(int k = 0; k < steps; k++){
				System.out.print(" ");
			}
			for(int j = i; j > 0; j--){
				System.out.print("* ");
			}
			steps--;
			System.out.println("");			
		}
		for(int i = count; i > 0; i--){
			for(int k = steps; k > 0; k--){
				System.out.print(" ");
			}
			for(int j = 0; j < i; j++){
				System.out.print("* ");
			}
			steps++;
			System.out.println("");			
		}
	}
}
		
			
