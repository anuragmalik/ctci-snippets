public class ReverseList {

	public static Node<Integer> reverseIterative(Node<Integer> node) {
		
		Node<Integer> prev = node;
		Node<Integer> curr = prev.getNext();
		Node<Integer> next = null;
		
		while(curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev.setNext(null);
			
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static Node<Integer> reverseRecursive(Node<Integer> node) {
		
		if (node.getNext() == null)
			return node;
			
		Node<Integer> first = node;
		Node<Integer> rest = node.getNext();
		first.setNext(null);
		
		Node<Integer> reversed = reverseRecursive(rest);
		rest.setNext(first);
		
		return reversed;
	}

	public static void main(String[] args) {
		
		Node<Integer> head = new Node<Integer> (2, new Node<Integer> (3, new Node<Integer> (4, null)));
		Node<Integer> node = reverseIterative(head);
		while(node != null) {
			System.out.println(node.getValue());
			node = node.getNext();
		}
		

	}

}
