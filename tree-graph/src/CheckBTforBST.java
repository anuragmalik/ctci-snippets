public class CheckBTforBST {
	
	BTNode root;
	public CheckBTforBST(BTNode root) {
		this.root = root;
	}
	
	public boolean checkIfBST() {
		return checkIfBSTUtil(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean checkIfBSTUtil(BTNode node, int min, int max) {
		if(node == null) return true;
		if ( node.value < min || node.value > max ) return false;
		
		return checkIfBSTUtil(node.left, min, node.value) &&
				checkIfBSTUtil(node.right, node.value, max);
	}
	
	public static void main(String[] args) {
		CheckBTforBST bTree = new CheckBTforBST(null);
		bTree.root = new BTNode(2, new BTNode(3, null, null), new BTNode(1, null, null));
		if(bTree.checkIfBST()) System.out.println("Tree is a BST");
		else System.out.println("Tree is not a BST");
			
		bTree.root = new BTNode(3, new BTNode(2, null, null), new BTNode(4, null, null));
		if(bTree.checkIfBST()) System.out.println("Tree is a BST");
		else System.out.println("Tree is not a BST");
		
		bTree.root = new BTNode(5, 		
						new BTNode(3, new BTNode(2, new BTNode(1, null, null), null),null), 
						new BTNode(9, new BTNode(8, new BTNode(7, null, null), null),null));
		if(bTree.checkIfBST()) System.out.println("Tree is a BST");
		else System.out.println("Tree is not a BST");
	}
}
