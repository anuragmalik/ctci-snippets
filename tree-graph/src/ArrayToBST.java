
public class ArrayToBST {
	public Node root;
	public Node fromArrayToBST(int[] data, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (end + start)/2;
		Node root = new Node(data[mid]);
		root.left = fromArrayToBST(data, start, mid - 1 );
		root.right = fromArrayToBST(data, mid + 1, end);
		return root;
	}
	public void inorder(Node node) {
		if (node == null ) return;
		else
		{
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

	class Node {
		int value;
		Node left;
		Node right;
		public Node ( int val) {
			this.value = val;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String[] args) {
		
		int[] data = new int[]{2,3,5,6,8,9};
		
		ArrayToBST arrBst = new ArrayToBST();
		arrBst.root = arrBst.fromArrayToBST(data, 0, data.length-1);
		arrBst.inorder(arrBst.root);
		System.out.println();
		data = new int[]{1,2,3,4,5,6,11,12,13,14,19};
		arrBst.root = arrBst.fromArrayToBST(data, 0, data.length-1);
		arrBst.inorder(arrBst.root);

	}

}
