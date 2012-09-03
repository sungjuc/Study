package lec.l25;

import lec.l22.TreeNode;

public class TreeUtils4 {
	public static void main(String[] args) {
		TreeNode<String> tree = new TreeNode<String> ("A");
		tree.setLeft(new TreeNode<String>("B"));
		tree.setRight(new TreeNode<String>("C"));
		tree.getLeft().setLeft(new TreeNode<String>("D"));
		tree.getLeft().setRight(new TreeNode<String>("E"));
		tree.getRight().setLeft(new TreeNode<String>("F"));

		System.out.println("Tree traversal using stack");
		TreeUtils4.printUsingStack(tree);

		System.out.println("Tree traversal using stack preorder");
		TreeUtils4.printPreOrder(tree);

		System.out.println("Tree traversal using queue");
		TreeUtils4.printUsingQueue(tree);
	}

	public static void printUsingStack(TreeNode<String> t) {
		if ( t == null )
			return;
		Stack<TreeNode<String>> stack = new StackImpl<TreeNode<String>>();
		stack.push(t);
		
		while(!stack.isEmpty()) {
			TreeNode<String> tree = stack.pop();
			System.out.print(tree.getData());
			if (tree.getLeft() != null)
				stack.push(tree.getLeft());
			if (tree.getRight() != null)
				stack.push(tree.getRight());
		}
		System.out.println();
	}

	public static void printPreOrder(TreeNode<String> t) {
		if (t == null)
			return;
		Stack<TreeNode<String>> stack = new StackImpl<TreeNode<String>>();
		stack.push(t);

		while(!stack.isEmpty()) {
			TreeNode<String> node = stack.pop();
			System.out.print(node.getData());
			if(node.getRight() != null)
				stack.push(node.getRight());
			if(node.getLeft() != null)
				stack.push(node.getLeft());
		}

		System.out.println();
	}

	public static void printUsingQueue(TreeNode<String> t) {
		if (t == null)
			return;
		Queue<TreeNode<String>> queue = new QueueImpl<TreeNode<String>>();
		queue.enqueue(t);
		
		while(!queue.isEmpty()) {
			TreeNode<String> node = queue.dequeue();
			System.out.print(node.getData());
			if(node.getLeft() != null)
				queue.enqueue(node.getLeft());
			if(node.getRight() != null)
				queue.enqueue(node.getRight());
		}

		System.out.println();
	}
}