public class Eligibles{
	public static void main(String [] args){
		int numL = 0;
		int count =0; 
		person [] group = new person [1000];
		while(!Console.EndOfFile()){
			group[numL] = new person();
			group[numL].getPerson();
			group[numL].putPerson();
			if(group[numL].IsEligible())
				count++;
			numL++;
		}
		System.out.println("Number of eligibles = "+count);
	}
}
		
		
