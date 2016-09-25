class BalancedBT {
	public BTNode root;

	public void checkBalance() {
		if (checkBalanceUtil(root) == -1)
			System.out.println("Tree is not balanced");
		else
			System.out.println("Tree is balanced");
	}

	public int checkBalanceUtil(BTNode node) {
		if (node == null) {
			return 0;
		}

		int left = checkBalanceUtil(node.left);
		if (left == -1)
			return -1;

		int right = checkBalanceUtil(node.right);
		if (right == -1)
			return -1;

		int diff = left > right ? left - right : right - left;
		if (diff > 1)
			return -1;

		return max(left, right) + 1;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public static void main(String args[]) {

		BalancedBT bTree = new BalancedBT();
		bTree.root = new BTNode(2,
				new BTNode(3, new BTNode(4, null, null), new BTNode(5, null, new BTNode(6, null, null))),
				new BTNode(1, new BTNode(8, null, null), new BTNode(7, null, null)));
		bTree.checkBalance();

		BalancedBT b2Tree = new BalancedBT();
		b2Tree.root = new BTNode(2,
				new BTNode(3, new BTNode(4, null, null),
						new BTNode(5, new BTNode(9, new BTNode(10, null, null), null), new BTNode(6, null, null))),
				new BTNode(1, new BTNode(7, null, null), null));
		b2Tree.checkBalance();

		BalancedBT b3Tree = new BalancedBT();
		b3Tree.root = new BTNode(2, new BTNode(3, null, null), new BTNode(1, null, new BTNode(4, null, null)));
		b3Tree.checkBalance();
	}
}
