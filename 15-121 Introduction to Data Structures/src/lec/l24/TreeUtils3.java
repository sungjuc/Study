package lec.l24;

import lec.l22.TreeNode;
import lec.l23.TreeUtils2;

public class TreeUtils3 {
	public static void main(String[] args) {
		TreeNode<String> tree = new TreeNode<String>("A");
		tree.setLeft(new TreeNode<String>("B"));
		tree.setRight(new TreeNode<String>("C"));
		tree.getLeft().setLeft(new TreeNode<String>("D"));
		tree.getLeft().setRight(new TreeNode<String>("E"));
		tree.getRight().setLeft(new TreeNode<String>("F"));
		tree.getRight().setRight(new TreeNode<String>("G"));

		System.out.println("Pre order: ");
		TreeUtils2.preorder(tree);

		System.out.println("\nGrow the tree with X");
		TreeUtils3.grow(tree, "X");
		TreeUtils2.preorder(tree);

		tree = new TreeNode<String>("A");
		tree.setLeft(new TreeNode<String>("B"));
		tree.setRight(new TreeNode<String>("C"));
		tree.getLeft().setLeft(new TreeNode<String>("D"));
		tree.getLeft().setRight(new TreeNode<String>("E"));
		tree.getRight().setLeft(new TreeNode<String>("F"));
		tree.getRight().setRight(new TreeNode<String>("G"));

		System.out.println("\nPre order: ");
		TreeUtils2.preorder(tree);

		System.out.println("\nGrow the tree with X");
		tree = TreeUtils3.grow2(tree, "X");
		TreeUtils2.preorder(tree);

		System.out.println("\nPrune the tree");
		tree = TreeUtils3.prune(tree);
		TreeUtils2.preorder(tree);

		System.out.println("\nPrune another tree");

		tree = new TreeNode<String>("A");
		tree.setLeft(new TreeNode<String>("B"));
		tree.setRight(new TreeNode<String>("C"));
		tree.getRight().setRight(new TreeNode<String>("G"));

		tree = TreeUtils3.prune(tree);
		TreeUtils2.preorder(tree);

		System.out.println("\nPrune another tree");

		tree = new TreeNode<String>("A");
		tree.setLeft(new TreeNode<String>("B"));

		tree = TreeUtils3.prune(tree);
		TreeUtils2.preorder(tree);
	}

	public static void grow(TreeNode<String> t, String s) {
		if (t.getLeft() == null)
			t.setLeft(new TreeNode<String>(s));
		else
			grow(t.getLeft(), s);

		if (t.getRight() == null)
			t.setRight(new TreeNode<String>(s));
		else
			grow(t.getRight(), s);
	}

	public static TreeNode<String> grow2(TreeNode<String> t, String s) {
		if (t == null)
			return new TreeNode<String>(s);
		t.setLeft(grow2(t.getLeft(), s));
		t.setRight(grow2(t.getRight(), s));

		return t;
	}

	public static TreeNode<String> prune(TreeNode<String> t) {
		if (t == null || t.getLeft() == null && t.getRight() == null)
			return null;
		t.setLeft(prune(t.getLeft()));
		t.setRight(prune(t.getRight()));
		return t;
	}
}