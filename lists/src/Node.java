
class Node<E> {
	Node<E> next;
	E value;

	@SuppressWarnings("unchecked")
	Node (E value, Node<Integer> node) {
		this.value =  value;
		this.next = (Node<E>) node;
	}
	public E getValue() {
		return value;
	}

	public void setValue(E val) {
		value = val;
	}

	@SuppressWarnings("unchecked")
	public void setNext(Node<Integer> node) {
		this.next = (Node<E>) node;
	}

	public Node<E> getNext() {
		return next;
	}
}