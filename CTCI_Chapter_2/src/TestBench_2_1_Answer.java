import java.util.Hashtable;

public class TestBench_2_1_Answer {
	public static void deleteDups (LinkedListNode n) {
		Hashtable<K, V> table = new Hashtable();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) previous.next = n.next;
			else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
}
