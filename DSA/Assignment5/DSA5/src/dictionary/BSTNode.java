package dictionary;

/**
 * Holds the structure for tree nodes
 * @author Gopal
 *
 */
public class BSTNode {

	private int key;
	private int value;
	private BSTNode leftChild;
	private BSTNode rightChild;

	public BSTNode(Object pairKey, Object pairValue){
		this.key = Integer.parseInt(pairKey.toString());
		this.value = Integer.parseInt(pairValue.toString());
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BSTNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}
}