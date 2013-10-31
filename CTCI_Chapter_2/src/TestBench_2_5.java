public class TestBench_2_5 {
	public static void findCross (MyNode head) {
		if ((head == null) || (head.getNext() == null)) return;
		MyNode slow = head, fast = head;
			// if x,y=num; x is not initialized
		slow = slow.getNext();
		fast = fast.getNext().getNext();
		while ( (slow != fast) && (slow != null) && (fast != null) ) {
			slow = slow.getNext();
			fast = fast.getNext();
			if (fast != null) fast = fast.getNext();
		}
		if ( (fast == null) || (slow == null) ) return;
		
		slow = head;
		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		System.out.printf("The satarting point of circle is: %d\n", slow.getValue());
	}
	
	public static void main (String[] args) {
		MyNode head = new MyNode(1);
		head.appendTail(2).appendTail(3).appendTail(4);
		MyNode cross = head.getNext().getNext().getNext(); // -> Node(4)
		head.appendTail(5).appendTail(6).appendTail(7).appendTail(8).appendTail(9).appendTail(10).appendTail(11);
		head.getTail().setNext(cross);
		
		TestBench_2_5.findCross(head);
		
	}
}
