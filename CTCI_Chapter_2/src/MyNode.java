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
		this.setNext(new MyNode(value));
		return this.getNext();
	}
	
	public boolean printList() {
		System.out.printf("%d ", value);
		if (getNext() != null) getNext().printList();
		return true;
	}
}
