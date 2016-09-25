public class PathDivK {

	public void findDivByK(BTNode root, int K) {
		int path[] = new int[1000];
		int pathLen = 0;
		findDivUtil(root, K, path, pathLen);
	}

	public void findDivUtil(BTNode node, int K, int[] path, int pathLen) {
		path[pathLen] = node.value;
		pathLen++;

		if (node.value % K == 0) {
			printPath(path, pathLen);
		}

		if (node.left != null)
			findDivUtil(node.left, K, path, pathLen);

		if (node.right != null)
			findDivUtil(node.right, K, path, pathLen);

	}

	public void printPath(int[] path, int pathLen) {
		int i = 0;
		System.out.println();
		while (pathLen-- > 0) {
			System.out.print(path[i++] + "-->");
		}
	}

	public static void main(String args[]) {

		BalancedBT bTree = new BalancedBT();
		bTree.root = new BTNode(2,
				new BTNode(3, new BTNode(4, null, null), new BTNode(5, null, new BTNode(6, null, null))),
				new BTNode(1, new BTNode(8, null, null), new BTNode(7, null, new BTNode(20, null, null))));
		PathDivK pathDiv = new PathDivK();
		pathDiv.findDivByK(bTree.root, 5);
	}
}
