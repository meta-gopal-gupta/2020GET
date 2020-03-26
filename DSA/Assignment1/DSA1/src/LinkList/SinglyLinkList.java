package LinkList;
/***
 * 
 * @author Gopal
 * Polynomial
 */

public class SinglyLinkList {
	static Node startNode = null;
	static int length = 0;

	/***
	 * 
	 * @param data
	 *            To add the node in the link list
	 */
	public static void addNode(int data) {
		Node newNode = new Node(data);
		length++;
		Node tempNode;
		if (startNode == null)
			startNode = newNode;
		else {
			tempNode = startNode;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = newNode;
		}
	}

	/***
	 * To display the link list
	 */
	public static void display() {
		Node tempNode = startNode;
		while (tempNode != null) {
			System.out.print(tempNode.data + "->");
			tempNode = tempNode.next;
		}
	}

	/***
	 * 
	 * @param L
	 * @param R
	 * @param N
	 * @return to rotate the sub link list
	 */
	public static int rotate(int L, int R, int N) {
		Node tempNode = startNode, prevOfL = null, prev = null, nodeAtRotaingNode = null;
		int count = 1, rotateNodes = R - L + 1, rotatingNode = rotateNodes - N
				+ 1;
		if (N % rotateNodes == 0)
			return 0;
		while (count != R) {
			if (count == L - 1)
				prevOfL = tempNode;
			if (count == rotatingNode) {
				prev = tempNode;
				nodeAtRotaingNode = tempNode.next;
			}
			tempNode = tempNode.next;
			count++;
		}
		prev.next = tempNode.next;
		tempNode.next = prevOfL.next;
		prevOfL.next = nodeAtRotaingNode;
		return 1;
	}

	/***
	 * To check that loop exist or not
	 * 
	 * @return true if loop exist
	 */
	public static boolean detectLoop() {
		Node tempNode = startNode, fast = startNode;
		while (tempNode != null && fast != null && fast.next != null) {
			tempNode = tempNode.next;
			fast = tempNode.next.next;
			if (tempNode == fast)
				return true;
		}
		return false;
	}

	
}
