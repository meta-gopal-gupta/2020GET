package chemistry;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	private List<String> list = new ArrayList<String>();

	public boolean createIndividualElementList(String string) {
		int length = string.length();
		int index = 0;

		while (index < length) {
			String temp = "";
			if (string.charAt(index) == ' ') {
				index++;
				continue;
			}
			if (string.charAt(index) >= '0' && string.charAt(index) <= '9') {
				temp += string.charAt(index);
				index++;
				while (index < length) {
					if (string.charAt(index) >= '0'
							&& string.charAt(index) <= '9') {
						temp += string.charAt(index);
						index++;
					}
					else {
						while (string.charAt(index) == ' ') {
							if (index < length - 1) {
								if (string.charAt(index) == ' '
										&& string.charAt(index + 1) >= '0'
										&& string.charAt(index + 1) <= '9') {
									return false;
								}
								index++;
							}
						}
						break;
					}
				}
			}
			else {
				temp += string.charAt(index);
				index++;
			}
			list.add(temp);
		}
		return true;

	}

	public int totalMass() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		int length = list.size() - 1;
		int temp = 1;
		int total = 0;
		
		while (length >= 0) {
			
			if (list.get(length).charAt(0) == ')') {
				intList.add(temp);
			}
			else if (list.get(length).charAt(0) == '(') {
				intList.remove(intList.size() - 1);
			}
			else if (list.get(length).charAt(0) > '0' && list.get(length).charAt(0) <= '9') {
				temp = (Integer.parseInt(list.get(length))) ;
			}
			else {
				int mass = getMass(list.get(length).charAt(0));
				if (mass == -1) {
					return -1;
				}
				if(length<list.size()-1){
					if(list.get(length+1).charAt(0)==')'){
						temp=1;
					}
				}
				total += mass * temp* intList.get(intList.size()-1);
				temp = 1;
			}
			length--;
		}
		return total;
	}
	public int getMass(char atom) {
		if (atom == 'c' || atom == 'C') {
			return 12;
		}
		if (atom == 'h' || atom == 'H') {
			return 1;
		}
		if (atom == 'o' || atom == 'O') {
			return 16;
		}
		return -1;
	}

}
