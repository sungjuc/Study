package lec.l22;

import lec.l20.Node;

public class LLUtils {
	public static void main(String[] args) {
		Node<String> nodeOne = new Node<String>("one", null);
		Node<String> nodeTwo = new Node<String>("two", nodeOne);
		Node<String> nodeThree = new Node<String>("three", nodeTwo);

		Node<String> list = nodeThree;

		System.out.println("Iterative size");
		System.out.println(LLUtils.size(list));

		System.out.println("\nRecursive size");
		System.out.println(LLUtils.sizeRecursive(list));
		
	}

	public static int size(Node<String> list) {
		int count = 0;
		
		while (list != null) {
			count++;
			list = list.getNext();
		}

		return count;
	}

	public static int sizeRecursive(Node<String> list) {
		if (list == null)
			return 0;
		return 1 + size(list.getNext());
	}
}