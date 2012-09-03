package lab.l05;

/**
 * LinkedList implements basic LL class.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 5
 */
public class LinkedList extends LL {
	/**
	 * public void removeAllMatchingItems(java.lang.Comparable keyItem) Removes
	 * each and every item equal to the keyItem from the list. The list is not
	 * changed in any other way. In the event of an error, it does not change
	 * the list, instead it returns leaving the list in its prior condition.
	 * 
	 * @param keyItem
	 *            Each and every item within the list equal to this item is
	 *            removed from the list.
	 */
	public void removeAllMatchingItmes(Comparable keyItem) {
		// If the list is empty, just return with printing warning message.
		if (head == null)
			System.out.println("(empty list)"
					+ System.getProperty("line.separator"));

		LLNode prev = null;

		// Iterate the list
		for (LLNode l = head; l != null; l = l.getNext()) {

			if (keyItem.equals(l.value)) {
				LLNode next = null;
				if (l.getNext() != null) {
					next = l.getNext();
				}
				if (l == head) // the first item.
					head = next;
				else
					prev.setNext(next);
			}
			prev = l;
		}
	}

	/**
	 * Removes items with odd indexes from the list. The first item in the list
	 * has index 0, the second index 1, etc. The 0th index is not to considered
	 * an odd index. In the event of an error, it does not change the list,
	 * instead it returns leaving the list in its prior condition.
	 */
	public void removeOddItems() {
		// If the list is empty, just return with printing warning message.
		if (head == null)
			System.out.println("(empty list)"
					+ System.getProperty("line.separator"));

		int index = 0;
		LLNode prev = null;

		for (LLNode l = head; l != null; l = l.getNext()) {
			// Remove the item in case that the index is odd number.
			if (index % 2 == 1) {
				prev.setNext(l.getNext());
			}
			prev = l;
			index++;
		}
	}
}