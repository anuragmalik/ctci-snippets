
public class ListPalindrome<E> {

	private class Result<E> {
		Node<E> node;
		boolean isSame;

		Result(Node<E> node, boolean same) {
			this.node = node;
			this.isSame = same;
		}
	}

	public boolean checkPalindrome(Node<E> head) {
		return recPalindrome(head, length(head)).isSame;
	}

	public Result<E> recPalindrome(Node<E> head, int len) {
		if (head == null || len == 0)
			return new Result<E>(head, true);
		else if (len == 1) {
			return new Result<E>(head.next, true);
		}

		Result<E> res = recPalindrome(head.next, len - 2);
		if (!res.isSame || res.node == null)
			return res;
		if (res.node.value != head.value)
			res.isSame = false;
		res.node = res.node.next;
		return res;
	}

	public int length(Node<E> head) {
		if (head == null)
			return 0;
		else
			return 1 + length(head.next);
	}

	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1,
				new Node<Integer>(2, new Node<Integer>(1, new Node<Integer>(1, null))));
		ListPalindrome<Integer> list = new ListPalindrome<Integer>();
		System.out.println(list.checkPalindrome(head));
	}

}
