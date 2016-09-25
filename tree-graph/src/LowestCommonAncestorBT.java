class Result {
	boolean found;
}

public class LowestCommonAncestorBT {
	public BTNode root;

	public BTNode findLowestCommonAncestor(BTNode node, BTNode nodeOne, BTNode nodeTwo, Result res) {

		if (node == null) {
			res.found = false;
			return null;
		}

		if (node == nodeOne && node == nodeTwo) {
			res.found = true;
			return node;
		}

		BTNode lt = findLowestCommonAncestor(node.left, nodeOne, nodeTwo, res);
		if (res.found == true)
			return lt;
		
		BTNode rt = findLowestCommonAncestor(node.right, nodeOne, nodeTwo, res);
		if (res.found == true)
			return rt;

		if (lt != null && rt != null) {
			res.found = true;
			return node;
		} else if ( node == nodeOne || node == nodeTwo ) {
			res.found = lt != null || rt != null? true: false;
			return node;
		} else {
			res.found = false;
			return lt != null ? lt : rt;
		} 
	}

	public static void main(String[] args) {

		LowestCommonAncestorBT bTree = new LowestCommonAncestorBT();
		BTNode bt4Node = new BTNode(4, null, null);
		BTNode bt2Node = new BTNode(2, null, null);
		BTNode bt5Node = new BTNode(5, bt4Node, null);
		BTNode bt3Node = new BTNode(3, bt2Node, bt5Node);
		BTNode bt11Node = new BTNode(11, null, null);

		bTree.root = new BTNode(8, bt3Node, new BTNode(10, new BTNode(9, null, null), bt11Node));
		Result res = new Result();
		res.found = false;
		System.out.println(bTree.findLowestCommonAncestor(bTree.root, bt2Node, bt5Node, res).value);
	}

}
