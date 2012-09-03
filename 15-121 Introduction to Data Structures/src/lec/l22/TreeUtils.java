package lec.l22;

public class TreeUtils {
	public static void main(String[] args) {
		TreeNode<String> parent = new TreeNode<String>("parent");
		parent.setLeft(new TreeNode<String>("left"));
		parent.setRight(new TreeNode<String>("right"));
		parent.getLeft().setLeft(new TreeNode<String>("leftleft"));
		parent.getRight().setRight(new TreeNode<String>("rightright"));

		System.out.println("Recursive size!");
		System.out.println(TreeUtils.size(parent));

		TreeNode<Integer> root = new TreeNode<Integer>(8);
		root.setLeft(new TreeNode<Integer>(1));
		root.setRight(new TreeNode<Integer>(9));
		root.getLeft().setRight(new TreeNode<Integer>(11));
		root.getRight().setLeft(new TreeNode<Integer>(5));

		System.out.println("\nGet maximum value from tree");
		System.out.println(TreeUtils.max(root));
		System.out.println("\nGet maximum value from tree in another way");
		System.out.println(TreeUtils.max2(root));
	}

	public static int size(TreeNode<String> t) {
		if (t == null)
			return 0;
		return 1 + size(t.getLeft()) + size(t.getRight());
	}

	public static int max(TreeNode<Integer> t) {
		if (t.getLeft() == null && t.getRight() == null)
			return t.getData();
		if (t.getLeft() == null)
			return Math.max(t.getData(), max(t.getRight()));
		if (t.getRight() == null)
			return Math.max(t.getData(), max(t.getLeft()));
		return Math.max(t.getData(), Math.max(max(t.getRight()), max(t
				.getLeft())));
	}

	public static int max2(TreeNode<Integer> t) {
		int max = t.getData();

		if (t.getLeft() != null) {
			int left = max2(t.getLeft());

			if (left > max)
				max = left;
		}

		if (t.getRight() != null) {
			int right = max2(t.getRight());

			if (right > max)
				max = right;
		}

		return max;
	}
}