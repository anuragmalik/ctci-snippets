
public class BSTInorderSuccessor {
	BTNode root;
	
	public BTNode findSuccessor(BTNode root, BTNode node) {
		
		if (node == null) return null;
		if (node.right != null) {
			return leftMostNode(node.right); 
		}
		
		BTNode succ = null;
		while (root != null) {			
			if(node.value < root.value) {
				succ = root;
				root = root.left;
			}
			else if (node.value > root.value)
				root = root.right;
			else
				break;
		}
		
		return succ;
	}
	
	public BTNode leftMostNode(BTNode node) {
		if (node == null) return null;
		if (node.left == null)
			return node;
		return leftMostNode(node.left);
	} 

	public static void main(String[] args) {
		BSTInorderSuccessor bTree = new BSTInorderSuccessor();
		BTNode bt4Node = new BTNode(4, null, null);
		BTNode bt3Node = new BTNode(3, new BTNode(2, null, null), new BTNode(5, bt4Node, null));
		BTNode bt11Node = new BTNode(11, null, null);
		
		bTree.root = new BTNode(8,bt3Node,
				new BTNode(10, new BTNode(9, null, null), bt11Node));
		
		System.out.println("Successor of 4 is : " + bTree.findSuccessor(bTree.root, bt4Node).value);
		System.out.println("Successor of 11 is : " + bTree.findSuccessor(bTree.root, bt11Node));
		System.out.println("Successor of 3 is : " + bTree.findSuccessor(bTree.root, bt3Node).value);
		
	}

}
