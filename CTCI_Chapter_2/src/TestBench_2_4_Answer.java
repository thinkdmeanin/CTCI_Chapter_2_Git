public class TestBench_2_4_Answer {
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
				// pass carryOut as arg & store sum in the current cycle is straight-forward
				// don't have to create a fullAdder method which is meaningless.
		if (l1 == null && l2 == null) {
			return null;
		}
		LinkedListNode result = new LinkedListNode(carry, null, null);
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value > 10 ? 1 : 1);
		result.setNext(more);
		return result;	
	}
}
