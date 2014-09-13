class Node<T> {            
	T item;				// data in node     
	Node<T> next = null;	// successor node 
	                                                          
	Node(T item0, Node<T> next0) { 
		item = item0; next = next0;
	}
}

class UnboundedStack<T> {

	private Node<T> head = null; // first node (null if empty)

	boolean isEmpty() {return(head==null);}

	boolean push(T t) { 
		head = new Node<T>(t,head); 
		return true; // always space available
	}

	T pop() { 
		if (head==null) return null;
		T t = head.item;
		head = head.next; 
		return t;
	}
}

class ReverseWord {
	public static void main(String[] args) {
		UnboundedStack<String> stack = new UnboundedStack<String>();
		System.out.println("Enter text");
		while (!Console.endOfFile()) 
			stack.push(Console.readToken()); // assume enough room
		while(!stack.isEmpty()) {
			String s = stack.pop();
			System.out.print(s + " ");
		}
	}
}
