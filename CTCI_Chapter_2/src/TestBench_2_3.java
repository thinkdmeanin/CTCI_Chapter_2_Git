public class TestBench_2_3 {
	public static void removeMid (MyNode mid) {
		MyNode next = mid.getNext();
		if (next == null) {	// in case the list only has 1 element
			mid = null;
			return;
		}
		mid.setValue(next.getValue());
		mid.setNext(next.getNext());
	}
	
	public static void main (String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		MyNode head = TestBench_2_2.createTestList(nums);
		
		TestBench_2_3.removeMid(head.getNext().getNext());
		System.out.println("After removed the middle :");
		head.printList();
	}
}
