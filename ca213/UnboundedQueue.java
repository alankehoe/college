class UnboundedQueue<T> {
	
	private static class Node<T> {            
		private T item;			// data in node     
		private Node<T> next = null;	// successor node 
		                                                          
		Node(T item0, Node<T> next0) { 
			item = item0; next = next0;
		}
	}
		
	private Node<T> head = null; 
	private Node<T> tail = null; // both null, or neither null

	boolean isEmpty() {return(head==null);}

	boolean enq(T t) { 
		Node<T> tNode = new Node<T>(t,null); // new tail node
		if (tail!=null) 
			tail.next = tNode; 
		else 
			head = tNode;
		tail = tNode;
		return true;
	}

	T deq() { 
		if(isEmpty())return null;
		T tmp = null;
		if(head.next == null)head = null;
		else
			head = head.next;
		return tmp;
	}
}

class SecretWords {
	public static void main(String[] args) {
		Secrets secrets = new Secrets();
		UnboundedQueue<String> q = new UnboundedQueue<String>(); 
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
