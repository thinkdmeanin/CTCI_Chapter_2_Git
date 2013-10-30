public class TestBench_2_2 {
	public static MyNode lastNthNd (MyNode head, int n) {
		if (head == null) return null;
		if (n < 1) return null;		
			// find last 0 or neg element or in a null linkedlist is meaningless
		MyNode ahead = head;
			// ahead ptr
		int len = 1;
			// len between ahead ptr & behind ptr
		while ( (len < n) && (ahead.getNext() != null)) {
				// travel until the tail | nth element from head
			ahead = ahead.getNext();
			++len;
		}
		
		if (len < n) return null;	// if list is shorter than n
		
		MyNode behind = head;	// behind ptr
		
		while (ahead.getNext() != null) {
				// trevel until ahead reaches tail and behind is nth element from ahead (tail) element
			ahead = ahead.getNext();
			behind = behind.getNext();
		}
		
		return behind;
	}
	
	public static MyNode createTestList(int[] nums) {
			// create a LinkedList for test, print it and return its head
		
		if (nums == null) return null;
		
			// create
		MyNode head = new MyNode(nums[0]);
		for (int i = 1; i < nums.length; ++i) {
			head.appendTail(nums[i]);
		}
			
			// print
		System.out.println("The tested LinkedList");
		head.printList();
		System.out.println();
		System.out.println();
		
			// return head
		return head;
	}
		
	public static void main (String[] args) {
		int[] nums = {1, 2, 3, 4};
		MyNode head = TestBench_2_2.createTestList(nums);
		
		for (int i = -1; i <= nums.length+2; ++i) {
				// test all specific position: neg, 0, last, the one before last, first, the one after first, beyond first
			MyNode returnNode = TestBench_2_2.lastNthNd(head, i);
			System.out.printf("TestBench_2_2.lastNthNd(head, %d) returns %s\t", i, returnNode);
			if (returnNode != null) System.out.printf("value: %d", returnNode.getValue());
			System.out.println();
			System.out.println();
		}
	}
}
