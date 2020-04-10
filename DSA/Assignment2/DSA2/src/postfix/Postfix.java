package postfix;

import java.util.ArrayList;

public class Postfix {

	private static ArrayList<String> stack = new ArrayList<String>();
	private static ArrayList<String> postFix = new ArrayList<String>();

	public static void calculate() {
		Node tempNode = Expression.startNode;
		while (tempNode != null) {
			char expression = tempNode.data.charAt(0);
			if (expression == '*' || expression == '/' || expression == '-' || expression == '+' || expression == '(')
			{
				if(expression != '('){
					if(stack.size()>0){
						char temp = stack.get(stack.size()-1).charAt(0);
						if(temp == '*' || temp == '/' ){
							postFix.add(""+temp);
							stack.remove(stack.size()-1);
						}
					}
				}
				stack.add(tempNode.data);
			}
			else if(expression == ')'){
				char temp = stack.get(stack.size()-1).charAt(0);
				
				while(temp != '('){
			
					postFix.add(""+temp);
					stack.remove(stack.size()-1);
					temp = stack.get(stack.size()-1).charAt(0);
				}
				stack.remove(stack.size()-1);
				
			}
			else{
				postFix.add(tempNode.data);
			}
			tempNode = tempNode.next;
		}
		
		while(!stack.isEmpty()){
			char temp = stack.get(stack.size()-1).charAt(0);
			postFix.add(""+temp);
			stack.remove(stack.size()-1);
		}
	}
	
	public static void displayPost() {
		System.out.println("Postfix Expression");
		for(int i = 0; i<postFix.size();i++){
			System.out.print(" "+postFix.get(i));
		}
		System.out.println();
	}
	
	public static int answer() {
		int result=0;
		int index =2;
		while(postFix.size()>2){
			
			if(!(postFix.get(index).charAt(0) >= '0' && postFix.get(index).charAt(0) <= '9')){
				int val1 = convertStringToInt(postFix.get(index-2));
				int val2 = convertStringToInt(postFix.get(index-1));
				if (postFix.get(index).charAt(0) == '+') result = (val1 + val2);
				else if (postFix.get(index).charAt(0) == '-')result = (val1 - val2);
				else if (postFix.get(index).charAt(0) == '*')result = (val1 * val2);
				else result = (val1 / val2);
				postFix.set(index-2, ""+ result);
				postFix.remove(index-1);
				postFix.remove(index-1);
				index=1;
			}
			index++;
			
		}
		return result;
	}
	
	public static int convertStringToInt(String inputValue) {
		int integerValue = 0;
		int length = inputValue.length();
		for (int index = 0; index < length; index++) {
			integerValue += (inputValue.charAt(index) - 48)
					* pow(10, length - 1 - index);
		}
		return integerValue;
	}

	public static int pow(int X, int Y) {
		int powerIs = 1;
		for (int i = 0; i < Y; i++) {
			powerIs *= X;
		}
		return powerIs;
	}

}
