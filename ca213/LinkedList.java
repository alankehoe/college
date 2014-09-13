import java.util.*;
    
class LinkedList<T> {
		
	private static class Node<T> {            
		private T item; 				// data       
		private Node<T> next = null;	// successor node 
	                                                          
		Node(T item0, Node<T> next0) { 
			item = item0; next = next0;
		}
	}
		
	private Node<T> head = null; // first node (null if list empty)
	private Node<T> tail = null; // final node (null if list empty)
	private int numItems = 0;	  // number of items

	public int size() {return(numItems);}

	public T get(int i) {
		if (i<0||i>=numItems) throw new IndexOutOfBoundsException();
		Node<T> p = head; int pIndex = 0; // Node p at index pIndex
		while (pIndex!=i) {
			p = p.next; pIndex++;
		}
		return p.item;
	}
	
 
	public T set(int i, T t) {
		if (i<0||i>=numItems) throw new IndexOutOfBoundsException();
		Node<T> p = head; int pIndex = 0; // Node p at index pIndex
		while (pIndex!=i) {
			p = p.next; pIndex++;
		}
		T temp = p.item; p.item = t;
		return temp;
	}
	
	public boolean add(T t) { 
		add(numItems,t);
		return true;
	}
	
	public void add(int i, T t) { 
		if (i<0 || i>numItems) throw new IndexOutOfBoundsException();
		if (i==0) { // insert at front
			head = new Node<T>(t,head);
			if (tail==null) tail = head;
		}
		else { // not at front
			Node<T> p = head;
			int pIndex = 0; // Node p is at position pIndex
			while (pIndex!=i-1) {
				p = p.next; pIndex++;
			} // node p at index i-1
			p.next = new Node<T>(t,p.next); // insert t following p
			if (tail==p) tail = p.next;
		}
		numItems++;
	}
		

	int indexOf(Object t) {
		Node<T> p = head;
		if(t == head)
			return 0;
		int index = 0;
		for(int i = 0;i < numItems; i++){
			if(p.item == t)
				return index;
			else{
				p = p.next;
				index++;
			}
		}
		return -1;
	}
	
	void addFirst(T t) {
		head = new Node<T>(t,head);
		numItems--;
	}
	
	T removeLast(){
		Node<T> p = tail;
		tail.item = get(numItems-2);
		numItems--;
		return p.item;
	}
}
	
class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<String> ws = new LinkedList<String>();
		ws.addFirst("cat");                                       
		ws.add("cow"); 
		ws.add("pig");
		System.out.println(ws.get(1));
		System.out.println(ws.indexOf("cat"));
		ws.removeLast();
		
	}
}
