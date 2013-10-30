public class TestBench_2_1 {
	public static void removeDup (MyNode head) {
		if (head == null) return;
		if (head.getNext() == null) return;
		
		boolean[] checkList = new boolean[256];
		MyNode before = head;
		checkList[before.getValue()] = true;
		
		while (before.getNext() != null) {
			if (checkList[before.getNext().getValue()]) {
				before.setNext(before.getNext().getNext());
					// one easy mistake here is  updating the current node after removing dup node
					// this will cause next node after dup node miss checking => nullPointer Excep
			} else {
				checkList[before.getNext().getValue()] = true;
				before = before.getNext();
			}
		}
	}
	
	public static void main (String[] args) {
		MyNode head = new MyNode(1);
		head.appendTail(2).appendTail(3).appendTail(1).appendTail(2).appendTail(4).appendTail(3);
		System.out.println("The tested LinkedList:");
		head.printList();
		System.out.println();
		
		TestBench_2_1.removeDup(head);
		System.out.println("The cleared LinkedList:");
		head.printList();
		
	}
}
