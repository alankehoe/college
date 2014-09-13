public class Isbn{
	static boolean correctLength(String s){
		if(s.length() > 13)
			return false;
		else 
			return true;
	}
	
	Static boolean lastCharIsCorrect(String s){
		if(CharAt(s.length()-1) > 0 <= 9 || CharAt(s.length()-1) == 'X');
			return true;
		else 
			return false;
	}
}
