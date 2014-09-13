public class Stock{
	
	static class item{
		String name;
		int level;
		double price;
		
		void getStock(){
			//System.out.println("enter stock :");
			name = Console.readToken();
			level = Console.readInt();
			price = Console.readDouble();
		}
		
		void putStock(){
			System.out.println("The "+name+" is worth most.");
		}
		
		double value(){
			double a = (int)level;
			return price * a;
		}
	}
	
	public static void main(String [] args){
		System.out.println("How many items :");
		int a = Console.readInt();
		item [] store = new item[a];
		double value = 0;
		int index = 0;
		System.out.println("enter stock :");
		for(int i = 0; i < a; i++){
			store[i] = new item();
			store[i].getStock();
			if(store[i].value() > value){
				value = store[i].value();
				index = i;
			}
		}
		store[index].putStock();
	}
}
			
		
