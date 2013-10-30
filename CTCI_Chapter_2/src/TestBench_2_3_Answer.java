public class TestBench_2_3_Answer {
	public static boolean deleteNode (LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;	// in case the list only has 1 node
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}
