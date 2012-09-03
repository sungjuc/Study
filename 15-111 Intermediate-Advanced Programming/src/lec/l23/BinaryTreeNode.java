package lec.l23;

public class BinaryTreeNode {
	public BinaryTreeNode(Comparable data) {
		this.data = data;
		left = null;
		right = null;
	}

	public BinaryTreeNode(Comparable data, BinaryTreeNode right,
			BinaryTreeNode left) {
		this.data = data;
		left = left;
		right = right;
	}

	public void setLeft(BinaryTreeNode left) {
		left = left;
	}

	public void setRight(BinaryTreeNode right) {
		right = right;
	}

	public Comparable data() {
		return data;
	}

	public BinaryTreeNode left() {
		return left;
	}

	public BinaryTreeNode right() {
		return right;
	}

	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

	Comparable data;
	BinaryTreeNode left;
	BinaryTreeNode right;
}
