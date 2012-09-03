package lec.l23;

public class BST {
	BinaryTreeNode root;

	void BSTInsert(BinaryTreeNode root, Comparable data) {
		if (this.root == null)
			this.root = new BinaryTreeNode(data);

		if (root.data().compareTo(data) == 0)
			return;

		if (root.data().compareTo(data) > 0)
			if (root.left() == null) {
				root.left = new BinaryTreeNode(data);
				return;
			} else {
				BSTInsert(root.left(), data);
				return;
			}

		if (root.data().compareTo(data) < 0)
			if (root.right() == null) {
				root.right = new BinaryTreeNode(data);
				return;
			} else {
				BSTInsert(root.right(), data);
				return;
			}
	}

	Comparable BSTFind(BinaryTreeNode root, Comparable data)
			throws NotFoundException {
		if (root == null)
			throw new NotFoundException("Item not found in BST");

		if (root.data().compareTo(data) == 0)
			return root.data();

		if (root.data().compareTo(data) > 0) {
			return BSTFind(root.left(), data);
		} else {
			return BSTFind(root.right(), data);
		}
	}

	void delete(Comparable c) {
		root = delete(root, c);
	}

	BinaryTreeNode delete(BinaryTreeNode root, Comparable c) {
		if (c == null)
			return root;

		if (root == null)
			return null;

		if (c.compareTo(root) == 0) {
			if (root.isLeaf())
				return null;
			if (root.right() == null)
				return root.left();
			if (root.left() == null)
				return root.right();

			Comparable replacement = getRightMost(root.left());

			return new BinaryTreeNode(replacement, delete(root.left(),
					replacement), root.right());
		} else if (c.compareTo(root.data()) > 0) {
			root.setLeft(delete(root.left(), c));
			return root;
		} else {
			root.setRight(delete(root.right(), c));
			return root;
		}

	}

	Comparable getRightMost(BinaryTreeNode btn) {
		if (btn == null)
			return null;

		if (btn.right() == null)
			return btn.data();

		return getRightMost(btn.right());
	}
}
