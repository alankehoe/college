class Queue<T> { // bounded

	private T[] seq = (T[])(new Object[10000]); // the sequence
	private int size = 0; // size of sequence
	private int head = 0; private int tail = 0; // front and rear

	boolean isEmpty() { return size==0;}

	boolean enq(T t) { 
		if (size<seq.length) {
				seq[tail] = t; tail = (tail+1)%seq.length; size++; 
				return true;
		}
		else return false;
	}

	T deq() {
		if (isEmpty()) return null;
		else {
			T temp = seq[head];
			head = (head+1)%seq.length; size--;
			return temp;
		}
	}
}

class SecretWord {
	public static void main(String[] args) {
		Secrets secrets = new Secrets();
		Queue<String> q = new Queue<String>(); 
		String w = ""; // w is the least possible solution
		// Always: The words in w followed by q are sorted 
		// lexicographically, and include a prefix of the 
		// lexicographically least word in secrets.
		while (!secrets.has(w)) {
			if (secrets.hasPrefix(w)) { // enqueue w+"a", w+"b", ...
				for (char ch='a'; ch<='z'; ch++) 
					q.enq(w+ch); 
			}
			w = q.deq(); 
		}
		System.out.println(w);
	}
}
