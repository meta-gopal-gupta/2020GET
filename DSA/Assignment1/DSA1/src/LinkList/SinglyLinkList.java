package LinkList;

/***
 * 
 * @author Gopal Polynomial
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
	 * @param L
	 * @param R
	 * @param N
	 * @return to rotate the sub link list
	 */
	public static void rotate(int L, int R, int N) {
		if (L < 1 || L >= R || R > length || N < 0) {
			System.out
					.println("\nNo rotation done because something is wrong in L,R,N ");
		}
		else {
			Node traverseNode = startNode;
			int sizeOfSubList = R - L + 1;
			int count = L - 1;
			Node subListStart;
			while (count > 0) {
				traverseNode = traverseNode.next;
				count -= 1;
			}
			subListStart = traverseNode;
			N = N % sizeOfSubList;
			while (N > 0) {
				sizeOfSubList = R - L;
				traverseNode = subListStart.next;
				int nextDataItem, dataItem = subListStart.data;
				while (sizeOfSubList > 0) {
					nextDataItem = traverseNode.data;
					traverseNode.data = dataItem;
					dataItem = nextDataItem;
					traverseNode = traverseNode.next;
					sizeOfSubList -= 1;
				}
				subListStart.data = dataItem;
				N -= 1;
			}

		}
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
