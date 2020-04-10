package dictionary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Functionalities of Dictionary
 * @author Gopal
 *
 */
public class DictionaryImpl implements Dictionary<Object, Object> {

	private BSTNode root;
	private ArrayList<BSTNode> sortedList;

	/**
	 * Initializes dictionary with JSON entry
	 */
	public DictionaryImpl() {
		root=null;
		sortedList = new ArrayList<BSTNode>();

		ReadJSON.readJSON();
		LinkedHashMap<Object,Object> pairs = ReadJSON.getDictMap();
		Set<Object> keys = pairs.keySet();
		for(Object k:keys){
			insertPair(k, pairs.get(k));
		}
	}

	/**
	 * To insert new key-value in dictionary
	 * @param key of node
	 * @param value of node
	 */
	public void insertPair(Object key,Object value){
		root = addPair(key, value, root);
	}

	@Override
	public BSTNode addPair(Object key, Object value, BSTNode root) {
		System.out.println("key = " + Integer.parseInt(key.toString()) + "value = " + Integer.parseInt(value.toString()));
		System.out.println("I'm in addPair()");
		if(root == null){
			root = new BSTNode(key, value);
			return root;
		}
		else{
			if(root.getKey() > Integer.parseInt(key.toString())){
				System.out.println("---------calling leftchild---root.key = "+ root.getKey());
				root.setLeftChild(addPair(key, value, root.getLeftChild()));
			}
			else{
				System.out.println("---------calling rightchild---root.key = "+ root.getKey());
				root.setRightChild(addPair(key, value, root.getRightChild()));
			}
		}
		return root;
	}

	/**
	 * To delete node from dictionary
	 * @param key of node
	 * @return deleted node
	 */
	public BSTNode delete(Object key){
		return deletePair(key, root);
	}

	@Override
	public BSTNode deletePair(Object key, BSTNode root) {

		if (root == null)
			return root;

		if (Integer.parseInt(key.toString()) < root.getKey()) {
			root.setLeftChild(deletePair(key,root.getLeftChild()));
		} else if (Integer.parseInt(key.toString()) > root.getKey()) {
			root.setRightChild(deletePair(key,root.getRightChild()));
		} else {

			if (root.getLeftChild() == null) {
				return root.getRightChild();
			} else if (root.getRightChild() == null)
				return root.getLeftChild();

			root.setKey(inOrderSuccessor(root.getRightChild()));
			root.setRightChild(deletePair(root.getKey(),root.getRightChild()));
		}

		return root;
	}

	/**
	 * To find the inorder successor for deletion
	 * @param root of tree
	 * @return key value of successor
	 */
	 private int inOrderSuccessor(BSTNode root) {
		 int minimum = root.getKey();
		 while (root.getLeftChild() != null) {
			 minimum = root.getLeftChild().getKey();
			 root = root.getLeftChild();
		 }
		 return minimum;
	 }

	 /**
	  * To find value corresponding to key
	  * @param key of node
	  * @return value
	  */
	 public int getValue(Object key){
		 return getValueToKey(key, root);
	 }

	 @Override
	 public int getValueToKey(Object key, BSTNode root){
		 if(root == null)
			 return -1;
		 if(root.getKey() == Integer.parseInt(key.toString()))
			 return root.getValue();
		 else if(root.getKey() > Integer.parseInt(key.toString()))
			 return getValueToKey(key, root.getLeftChild());
		 else
			 return getValueToKey(key, root.getRightChild());
	 }

	 /**
	  * To sort the dictionary
	  * @return sorted list
	  */
	 public ArrayList<BSTNode> sortedList(){
		 System.out.println("\nSorted List");
		 getSortedList(root);
		 return sortedList;
	 }

	 @Override
	 public void getSortedList(BSTNode root){
		 if (root != null) { 
			 getSortedList(root.getLeftChild()); 
			 sortedList.add(root);
			 System.out.println(root.getKey());
			 getSortedList(root.getRightChild()); 
		 }
	 }

	 /**
	  * To sort dictionary in given range of keys both inclusive
	  * @param key1 min limit
	  * @param key2 max limit
	  * @return sorted list
	  */
	 public ArrayList<BSTNode> sortedListInRange(Object key1, Object key2){
		 return getSortedListRange(key1, key2, root);
	 }

	 @Override
	 public ArrayList<BSTNode> getSortedListRange(Object key1, Object key2, BSTNode root) {
		 ArrayList<BSTNode> sortedInRange = new ArrayList<BSTNode>();
		 if(sortedList == null)
			 getSortedList(root);
		 for(int i= 0 ; i< sortedList.size(); i++){
			 if(sortedList.get(i).getKey() >= Integer.parseInt(key1.toString()) && sortedList.get(i).getKey() <= Integer.parseInt(key2.toString()))
				 sortedInRange.add(sortedList.get(i));

		 }
		 return sortedInRange;
	 }

}
