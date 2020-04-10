package dictionary;

import java.util.ArrayList;

/**
 * 
 * @author Gopal
 *
 */
public interface Dictionary<P,Q> {

	
	BSTNode addPair(P key, Q value, BSTNode root);

	
	BSTNode deletePair(P key ,BSTNode root);

	
	int getValueToKey(P key, BSTNode root);


	void getSortedList(BSTNode root);

	
	ArrayList<BSTNode> getSortedListRange(P key1,P key2, BSTNode root);
}