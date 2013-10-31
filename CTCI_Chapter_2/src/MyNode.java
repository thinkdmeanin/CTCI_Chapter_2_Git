public class MyNode {
	private int value;
	private MyNode next;
	 
	public boolean setValue(int value) {
		this.value = value;
		return true;
	}
	public boolean setNext(MyNode next) {
		this.next = next;
		return true;
	}
	
	public int getValue() {
		return value;
	}
	
	public MyNode getNext() {
		return next;
	}
	
	public MyNode () {
	}
	
	public MyNode (int value) {
		setValue(value);
	}
	
	public MyNode (MyNode next) {
		setNext(next);
	}
	
	public MyNode (int value, MyNode next) {
		setValue(value);
		setNext(next);
	}
	
	public MyNode appendTail (int value) {
			// one stupid design here before is return the element next before the tail
			// now always returns head
		MyNode tail = this;
		while (tail.getNext() != null) tail = tail.getNext();	// find tail
		tail.setNext(new MyNode(value));	// append to tail
		return this;	// return head
	}
	
	public MyNode appendHead (int value) {
		MyNode newHead = new MyNode(value);
		newHead.setNext(this);
		return newHead;
	}
	
	public MyNode getTail() {
		MyNode tail = this;
		while (tail.getNext() != null) tail = tail.getNext();	// find tail
		return tail;
	}
	
	public boolean printList() {
		System.out.printf("%d ", value);
		if (getNext() != null) getNext().printList();
		return true;
	}
}
