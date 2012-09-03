package lec.l23;

import lec.l22.TreeNode;

public class TreeUtils2 {
	public static void main(String[] args) {
		TreeNode<String> tree = new TreeNode<String> ("A");
		tree.setLeft(new TreeNode<String>("B"));
		tree.setRight(new TreeNode<String>("C"));
		tree.getLeft().setLeft(new TreeNode<String>("D"));
		tree.getLeft().setRight(new TreeNode<String>("E"));
		tree.getRight().setLeft(new TreeNode<String>("F"));
		tree.getRight().setRight(new TreeNode<String>("G"));

		System.out.println("Pre order: ");
		TreeUtils2.preorder(tree);

		System.out.println();
		System.out.println("In order: ");
		TreeUtils2.inorder(tree);

		System.out.println();
		System.out.println("G: " + TreeUtils2.contains(tree, "G"));
		System.out.println("C: " + TreeUtils2.contains(tree, "C"));
		System.out.println("A: " + TreeUtils2.contains(tree, "A"));
		System.out.println("X: " + TreeUtils2.contains(tree, "X"));

		System.out.println("The number of leaf nodes: " + TreeUtils2.countLeaves(tree));
		System.out.println("The level of tree: " + TreeUtils2.countLevels(tree));

		System.out.println("Build tree with " + "K");
		TreeNode<String> buildTree = TreeUtils2.build(3, "K");
		TreeUtils2.inorder(buildTree);
	}

	public static void preorder(TreeNode<String> t) {
		if (t == null)
			return;
		System.out.print(t.getData());
		preorder(t.getLeft());
		preorder(t.getRight());
	}

	public static void inorder(TreeNode<String> t) {
		if (t == null)
			return;
		inorder(t.getLeft());
		System.out.print(t.getData());
		inorder(t.getRight());
	}

	public static boolean contains(TreeNode<String> t, String s) {
		if ( t == null ) 
			return false;
		return t.getData().equals(s)
			|| contains(t.getLeft(), s)
			|| contains(t.getRight(), s); 

	}

	public static int countLeaves(TreeNode<String> t) {
		if (t == null)
			return 0;
		if (t.getLeft() == null && t.getRight() == null)
			return 1;
		return countLeaves(t.getLeft()) + countLeaves(t.getRight());	
	}

	public static int countLevels(TreeNode<String> t) {
		if ( t == null )
			return 0;
		int left = countLevels(t.getLeft());
		int right = countLevels(t.getRight());
		if (left > right)
			return 1 + left;
		else
			return 1 + right;
	}

	public static TreeNode<String> build(int n, String s) {
		if ( n == 0 )
			return null;
		TreeNode<String> t = new TreeNode<String>(s);
		t.setLeft(build(n - 1, s));
		t.setRight(build(n - 1, s));
	
		return t;
	}

}