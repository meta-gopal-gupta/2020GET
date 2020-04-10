package uniquechar;

import java.util.HashSet;
import java.util.Set;

public class UniqueChar {

	private Set<Character> charSet = new HashSet<Character>();
	public boolean addCharFromString(String inputString){
		if(inputString.trim().length() == 0){
			return false;
		}
		char[] charArray = inputString.toCharArray();
		for(int i =0;i<charArray.length;i++){
			charSet.add(charArray[i]);
		}
		return true;
	}
	
	public int sizeOfSet(){
		return charSet.size();
	}
}
