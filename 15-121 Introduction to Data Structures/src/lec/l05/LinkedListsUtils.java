package lec.l05;

public class LinkedListsUtils {
	public static String getThird(Node list) {
		return list.getNext().getNext().getData();
	}

	public static void insertSecond(Node list, String s) {
		Node second = new Node(s, null);
		second.setNext(list.getNext());
		list.setNext(second);
	}

	public static int size(Node list) {
		int count = 0;

		while (list != null) {
			count++;
			list = list.getNext();
		}

		return count;
	}
}
