class Stack<T> { // bounded

	private T[] seq = (T[])(new Object[10000]); // the sequence
	private int size = 0; // size of sequence
	
	boolean isEmpty() { return size==0;}

	boolean push(T t) { 
		if (size<seq.length) {
				seq[size] = t; size++; return true;
		}
		else return false;
	}
	
	T pop() {
		if (isEmpty()) return null;
		else {
			size--; return seq[size];
		}
	}
}

class ReverseWords {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		System.out.println("Enter text");
		while (!Console.endOfFile()) 
			stack.push(Console.readToken()); // assume enough room
		while(!stack.isEmpty()) {
			String s = stack.pop();
			System.out.print(s + " ");
		}
		System.out.println("");
	}
}
