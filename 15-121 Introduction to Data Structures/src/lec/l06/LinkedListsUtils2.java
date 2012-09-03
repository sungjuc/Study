package lec.l06;

import lec.l05.Node;

public class LinkedListsUtils2 {
	public static Node addLast(Node list, String s) {
		if (list == null)
			return new Node(s, null);

		Node temp = list;
		while (temp.getNext() != null)
			temp = temp.getNext();

		temp.setNext(new Node(s, null));
		return list;
	}

	public static Node removeLast(Node list) {
		if (list.getNext() == null)
			return null;

		Node temp = list;

		while (temp.getNext().getNext() != null)
			temp = temp.getNext();

		temp.setNext(null);
		return list;
	}
}
