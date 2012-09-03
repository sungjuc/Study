package lec.l22;

public class TreeNode<E> {
	private E data;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public E getData() {
		return this.data;
	}

	public TreeNode<E> getLeft() {
		return this.left;
	}

	public TreeNode<E> getRight() {
		return this.right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(TreeNode<E> node) {
		this.left = node;
	}

	public void setRight(TreeNode<E> node) {
		this.right = node;
	}
}