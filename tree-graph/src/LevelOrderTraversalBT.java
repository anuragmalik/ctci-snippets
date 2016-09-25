import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;



public class LevelOrderTraversalBT {

	public BTNode root;

	public LinkedList<Integer> spiralLevelOrdTraversal(BTNode node) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		Stack<BTNode> stack1 = new Stack<BTNode>();
		Stack<BTNode> stack2 = new Stack<BTNode>();
		stack1.push(node);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(!stack1.isEmpty()) {
				BTNode curr = stack1.pop();
				res.add(curr.value);
				
				if(curr.right != null) {
					stack2.push(curr.right);
				}
				if(curr.left != null) {
					stack2.push(curr.left);
				}
			}
			
			while(!stack2.isEmpty()) {
				BTNode curr = stack2.pop();
				res.add(curr.value);
				
				if(curr.left != null) {
					stack1.push(curr.left);
				}
				if(curr.right != null) {
					stack1.push(curr.right);
				}
			}
		}
		
		return res;
	}
	
	public LinkedList<Integer> levelOrdTraversal(BTNode node) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BTNode curr = queue.poll();
			res.add(curr.value);

			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}

		return res;
	}

	
	public ArrayList<LinkedList<BTNode>> levelOrderLinkLists(BTNode node) {
		ArrayList<LinkedList<BTNode>> resList = new ArrayList<LinkedList<BTNode>>();
		LinkedList<BTNode> current = new LinkedList<BTNode>();
		current.add(node);
		
		LinkedList<BTNode> parents;
		while(!current.isEmpty()) {
			resList.add(current);
			parents = current;
			current = new LinkedList<BTNode>();
			for(BTNode parent: parents) {
				if(parent.left != null) current.add(parent.left);
				if(parent.right != null) current.add(parent.right);
			}
		}
		return resList;
	}
	
	public static void main(String[] args) {
		LevelOrderTraversalBT tree = new LevelOrderTraversalBT();
		tree.root = new BTNode(2,
				new BTNode(3, new BTNode(4, null, null),
						new BTNode(5, new BTNode(9, new BTNode(10, null, null), null), new BTNode(6, null, null))),
				new BTNode(1, new BTNode(7, null, null), null));

		System.out.println("Level Order Traversal");
		ListIterator<Integer> lt = tree.levelOrdTraversal(tree.root).listIterator();
		while(lt.hasNext()) System.out.print(lt.next()+ " ");
		
		System.out.println("\nSpiral Level Order Traversal");
		lt = tree.spiralLevelOrdTraversal(tree.root).listIterator();
		while(lt.hasNext()) System.out.print(lt.next() + " ");
		
		
		System.out.println("\nLevel Ordered Linked Lists");
		ArrayList<LinkedList<BTNode>> lists = tree.levelOrderLinkLists(tree.root);
		ListIterator<BTNode> ltn;
		for(LinkedList<BTNode> list: lists) {
			ltn = list.listIterator();
			while(ltn.hasNext()) System.out.print(ltn.next().value + " ");
			System.out.println();
		}
	}

}
