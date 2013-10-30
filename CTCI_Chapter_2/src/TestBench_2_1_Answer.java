import java.util.Hashtable;

public class TestBench_2_1_Answer {
	public static void deleteDups (LinkedListNode n) {
		Hashtable<K, V> table = new Hashtable();	
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) previous.next = n.next;	// Hashtable.containsKey(key) checks contain or not
			else {
				table.put(n.data, true);	// Hashtable also use put to put key & val
					// How fast, large is Hashtable/map compared to array??
				previous = n;
			}
			n = n.next;
		}
	}
}
