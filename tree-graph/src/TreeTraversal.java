import java.util.Stack;

public class TreeTraversal {
	public void preOrderTraversalUsingStack(BTNode node) {
		Stack<BTNode> stack = new Stack<BTNode>();
		if (node == null)
			return;

		stack.push(node);
		BTNode temp;

		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.value + " ");

			if (temp.right != null) {
				stack.push(temp.right);
			}

			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

	public void postOrderTraversalUsingStack(BTNode node) {
		Stack<BTNode> stack = new Stack<BTNode>();
		if (node == null)
			return;

		stack.push(node);
		BTNode temp;

		while (node.left != null) {
			stack.push(node.left);
			node = node.left;
		}

		while (!stack.isEmpty()) {
			temp = stack.peek();
			
			if (temp.right != null) {
				node = temp.right;
				
				while (node.left != null) {
					stack.push(node.left);
					node = node.left;
				}
			}
			else
				System.out.print(stack.pop().value + " ");

		}
	}

	public void inOrderTraversalUsingStack(BTNode node) {
		Stack<BTNode> stack = new Stack<BTNode>();
		if (node == null)
			return;
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		BTNode temp;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.value + " ");

			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}

	public static void main(String[] args) {

		BalancedBT bTree = new BalancedBT();
		bTree.root = new BTNode(2,
				new BTNode(3, new BTNode(4, null, null), new BTNode(5, null, new BTNode(6, null, null))),
				new BTNode(1, new BTNode(8, null, null), new BTNode(7, null, new BTNode(20, null, null))));
		TreeTraversal inTrav = new TreeTraversal();
		inTrav.inOrderTraversalUsingStack(bTree.root);
		System.out.println();
		inTrav.preOrderTraversalUsingStack(bTree.root);
		System.out.println();
		inTrav.postOrderTraversalUsingStack(bTree.root);
	}

}
