import java.util.*;

class ArrayList<T> {
	
	private T[] seq = (T[])(new Object[1024]); // 1024 arbitrary
	private int numItems = 0; // seq[0..numItems-1] significant
		
	public int size() {return(numItems);}
	
	public T get(int i) {
		if (i<0||i>=numItems) throw new IndexOutOfBoundsException();
		else return seq[i];
	}
	
	public T set(int i, T t) {
		if (i<0||i>=numItems) throw new IndexOutOfBoundsException();
		else { 
			T temp = seq[i]; seq[i] = t;
			return temp;
		}
	}

	public boolean add(T t) { 
		add(numItems,t);
		return true; // or false -- for compatibility reasons only
	}

	public void add(int i, T t) {
		if (i<0 || i>numItems) throw new IndexOutOfBoundsException();
		if (numItems==seq.length) resize(); // extend seq
		for (int k=numItems; k>i; k--) // shift seq[i..] to right
			seq[k] = seq[k-1];
		seq[i] = t; numItems++;
	}						
	private void resize() { // seq is full -- double its size
		T[] temp = (T[])(new Object[seq.length*2]); // bigger array
		for (int i=0; i<seq.length; i++) // copy over items 
			temp[i] = seq[i];
		seq = temp; 
		// alternative body: seq = Arrays.copyOf(seq,seq.length*2);
	}
								
	int indexOf(Object t){
		int i = 0;
		for(i = 0;i < numItems;i++){
			if(seq[i].equals(t)){
				return i;
			}
		}
		return -1;
	}
	
	void addFirst(T t){
		if(numItems == seq.length)resize();
		for(int i = numItems; i > 0 ;i--){
			seq[i] = seq[i-1];
		}
		seq[0] = t;
		numItems++;
	}
	
	T remove(int i){
		T tmp = seq[i];
		for(int j = i+1; j < numItems; j++){
			seq[j-i] = seq[j];
		}
		numItems--;
		return tmp;
	}
}

class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> ws = new ArrayList<String>();
		ws.addFirst("cat"); ws.addFirst("dog");                                         
		ws.addFirst("cow"); ws.addFirst("dog");
		ws.addFirst("pig");
		System.out.println(ws.indexOf("dog"));
		ws.remove(ws.indexOf("dog"));
		System.out.println(ws.indexOf("dog"));	
		System.out.println(ws.indexOf("hen"));	
	}
}
