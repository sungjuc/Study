package lab.l06;

/**
 * BinaryTree class.
 * 
 * @author sungju.cho
 * @version 15-111 Intermediate/Advanced Programming Lab 6
 */
public class BinaryTree {

	/**
	 * Creates and returns an exact copy of the tree. This copy organizes the
	 * same items and has the same structure. It does not duplicate the
	 * reference data stored within each Node. Instead, it duplicate only the
	 * tree and the nodes it contains
	 * 
	 * This method does not change any of the items or the structure of the
	 * original tree.
	 * 
	 * In the event of an error, it returns null.
	 * 
	 * @return an exact copy of the tree. This copy organizes the same items and
	 *         has the same structure.
	 */
	public BinaryTree cloneTree() {
		// Create new binary tree reference
		BinaryTree newTree = new BinaryTree();

		// Copy the reference to the root node is enough
		newTree.root = this.root;

		return newTree;
	}

	/**
	 * Returns the level of the leaf that is farthest from the top (root) of the
	 * tree.
	 * 
	 * The root is considered to be at level 0.
	 * 
	 * This method does not change any of the items or the structure of the
	 * original tree.
	 * 
	 * In the event of an error, it returns -1
	 * 
	 * @return the level of the leaf that is farthest from the top (root) of the
	 *         tree.
	 */
	public int maxLeafLevel() {
		if (root == null)
			return -1;
		return maxLeafLevel(root);
	}

	private int maxLeafLevel(BinaryTreeNode node) {
		int level = 0;
		if (node == null) {
			return -1;
		}

		// Increase level since there is items.
		level++;
		level += Math.max(maxLeafLevel(node.getLeft()), maxLeafLevel(node
				.getRight()));

		return level;
	}

	/**
	 * Prints the value at each node between and including the root and the
	 * supplied keyValue. If keyValue is not present in the tree, nothing is
	 * printed.
	 * 
	 * This method does not change any of the items or the structure of the
	 * original tree.
	 * 
	 * It can print the nodes in any order, but cannot use a collection class.
	 * 
	 * @param keyValue
	 */
	public void printPath(java.lang.Comparable keyValue) {
		boolean isFound = true;
		// If there is no data, just return
		if (this.root == null)
			return;
		// String for result printed
		String result = "";

		if (keyValue.compareTo(root.getValue()) == 0) {
			result = root.getValue().toString();
			System.out.println("keyValue:" + keyValue + "\tpath: " + result);
			return;
		}

		try {
			result += findItem(root, keyValue);
		} catch (NotFoundException ex) {
			// No value is in the item just ignore it.
			isFound = false;
		}

		if (isFound)
			System.out.println("keyValue:" + keyValue + "\tpath: " + result);
	}

	private String findItem(BinaryTreeNode root, Comparable value)
			throws NotFoundException {
		if (root == null)
			throw new NotFoundException();

		String result = root.getValue().toString();

		if (value.compareTo(root.getValue()) > 0)
			result += "-" + findItem(root.getRight(), value);

		if (value.compareTo(root.getValue()) < 0)
			result += "-" + findItem(root.getLeft(), value);

		return result;
	}

	private class NotFoundException extends Exception {

	}

	/**
	 * Prints to the console a list of all items organized at the specified
	 * level of the tree. If level greater than the height of the tree or no
	 * leaves at the given level, nothing is printed. For negative heights print
	 * nothing
	 * 
	 * This method does not change any of the items or the structure of the
	 * original tree.
	 * 
	 * It can print all the leaves at the specified level
	 * 
	 * @param level
	 */
	public void printLeavesAtLevel(int level) {
		if (root == null) {
			return;
		}

		String result = levesAtLevel(root, level);
		if (!result.equals(""))
			System.out.println(result);
	}

	private String levesAtLevel(BinaryTreeNode node, int level) {
		String result = "";

		if (node == null || level < 0)
			return result;

		if (level == 0) {
			result += " " + node.getValue().toString();
			return result;
		}

		level--;

		String leftResult = levesAtLevel(node.getLeft(), level);
		String rightResult = levesAtLevel(node.getRight(), level);
		return leftResult + rightResult;
	}

	protected BinaryTreeNode root;

	/**
	 * The default constructor: creates an empty binary search tree
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Inserts a value into the proper position of a binary search tree.
	 * 
	 * @param value
	 *            to be inserted into the binary search tree
	 */
	public void insert(Comparable data) {
		if (null == data)
			return;

		root = insert(root, data);
	}

	/**
	 * This is a helper method -- no further description available
	 */
	protected BinaryTreeNode insert(BinaryTreeNode root, Comparable value) {
		if (null == root)
			return new BinaryTreeNode(value);

		if (value.compareTo(root.getValue()) == 0)
			return root;

		if (value.compareTo(root.getValue()) < 0)
			root.setLeft(insert(root.getLeft(), value));
		else
			root.setRight(insert(root.getRight(), value));

		return root;
	}

	/**
	 * This is a helper method -- no further description available
	 */
	protected String niceTreeString(BinaryTreeNode t, String indent) {
		return (t == null ? "" : (t.getRight() == null ? "" : niceTreeString(t
				.getRight(), "  " + indent))
				+ indent
				+ t.getValue()
				+ System.getProperty("line.separator")
				+ (t.getLeft() == null ? "" : niceTreeString(t.getLeft(), "  "
						+ indent)));
	}

	/**
	 * Provides a nice string represention of a BinaryTree.
	 * <p>
	 * Students should not concern themselves with how it works -- an
	 * understanding of this is not important to this exam.
	 */
	public String toString() {
		if (root == null)
			return "(empty tree)";
		else
			return niceTreeString(root, "  ");
	}

	protected class BinaryTreeNode {

		// Public instance variables: no need for getters/settors

		/**
		 * Note <code>final</code> access modifier: cannot be changed! Also,
		 * there is no setter for <code>value</code>.
		 */
		public final Comparable value;

		public BinaryTreeNode left, right;

		/**
		 * Constructor builds the BinaryTreeNode with the supplied parameter; it
		 * has empty subtrees.
		 * 
		 * @param value
		 *            to store in this node
		 */
		public BinaryTreeNode(Comparable value) {
			this.value = value;
			this.left = this.right = null;
		}

		/**
		 * Constructor builds the BinaryTreeNode with the supplied parameters.
		 * 
		 * @param value
		 *            to store in this node
		 * @param left
		 *            must refer to its left subtree
		 * @param right
		 *            must refer to its right subtree
		 */
		public BinaryTreeNode(Comparable value, BinaryTreeNode left,
				BinaryTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		// ////////
		//
		// Getters and Setters for those students who want to use them.
		//
		// ////////

		/**
		 * Returns reference to the left child, or null, if none.
		 * 
		 * @return reference to left child
		 */
		public BinaryTreeNode getLeft() {
			return left;
		}

		/**
		 * Returns reference to the right child, or null, if none.
		 * 
		 * @return reference to right child
		 */
		public BinaryTreeNode getRight() {
			return right;
		}

		/**
		 * Sets the left-child reference of this object to the parameter object.
		 * 
		 * @param newLeftChild
		 *            which is an object of the class BinaryTreeNode
		 */
		public void setLeft(BinaryTreeNode newLeftChild) {
			left = newLeftChild;
		}

		/**
		 * Sets the right-child reference of this object to the parameter
		 * object.
		 * 
		 * @param newRightChild
		 *            which is an object of the class BinaryTreeNode
		 */
		public void setRight(BinaryTreeNode newRightChild) {
			right = newRightChild;
		}

		/**
		 * Returns reference to the value of the object.
		 * 
		 * @return reference to the value
		 */

		public Comparable getValue() {
			return value;
		}

		/**
		 * Returns string representation of the object
		 * 
		 * @return String reference
		 */
		public String toString() {
			return value.toString();
		}
	}
}
