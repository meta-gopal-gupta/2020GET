
public class IntSet {

	private final int array[];
	
	/**
	 * Constructor to initialize the array
	 * @param inputArray
	 */
	public IntSet(int[] inputArray){
		this.array = sortArray(inputArray);
	}
	
	/**
	 * check whether x is a member of the set and return a boolean value
	 * @param x
	 * @return true if x exist in array
	 */
	boolean isMember(int x){
		int length = sizeOfArray(array);
		for(int index=0;index<length;index++){
			if(array[index]==x){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param list
	 * @return sorted array
	 */
	int[] sortArray(int[] list){
		int length =sizeOfArray(list);
		for(int index=0;index<length;index++){
			for(int nextIndex=index+1;nextIndex<length;nextIndex++){
				if(list[index]>list[nextIndex]){
					int temp = list[index];
					list[index] = list[nextIndex];
					list[nextIndex] = temp;
				}
			}
		}		
		return list;
	}
	
	/**
	 * 
	 * @param array
	 * @return - return the size of the set
	 */
	int sizeOfArray(int[] array){
		int length=0;
		for(int arrayElement : array){
			length++;
		}
		return length;
	}
	
	/**
	 * 
	 * @param array
	 * @return - return the size of the set
	 */
	int size(){
		int length=0;
		for(int arrayElement : array){
			length++;
		}
		return length;
	}
	
	
	
	/**
	 * 
	 * @param subObject
	 * @return true if subset
	 */
	boolean isSubSet(IntSet subObject){
		int lengthOfSet = sizeOfArray(array);
		int lengthofSubSet = sizeOfArray(subObject.array);
		if(lengthofSubSet==0){
			return true;
		}
		int indexOfSubSet=0;
		for(int indexOfSet=0;indexOfSet<lengthOfSet;indexOfSet++){
			if(array[indexOfSet]==subObject.array[indexOfSubSet]){
				indexOfSubSet++;
			}
			if(indexOfSubSet==lengthofSubSet){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * return the complement set, you can assume that 1..1000 is the universal set
	 * @return
	 */
	int[] getComplement(){
		int length = sizeOfArray(array);
		int[] complementArray = new int[1000-length];
		int index=0;
		int complementArrayIndex=0;
		for(int univasalValue=1;univasalValue<=1000;univasalValue++){
			if(index < length){
				if(array[index]==univasalValue ){
					index++;
					continue;
				}
			}
			complementArray[complementArrayIndex]=univasalValue;
			complementArrayIndex++;
		}
		return complementArray;
	}
	
	
	/**
	 * 
	 * @param a object of IntSet
	 * @param bobject of IntSet
	 * @return - return the union of a and b 
	 */
	int[] union(IntSet a,IntSet b){
		int lengthOfa = sizeOfArray(a.array);
		int lengthOfb = sizeOfArray(b.array);
		
		int index=0;
		int commonIntegers=0,indexOfa,k=0,unionArrayIndex=0;
		for(indexOfa=0;indexOfa<lengthOfa;indexOfa++){
			for(int indexofb=0;indexofb<lengthOfb;indexofb++){
				if(a.array[indexOfa]==b.array[indexofb]){
					commonIntegers++;
					break;
				}
			}
		}
		
		int[] unionArray = new int[lengthOfa+lengthOfb-commonIntegers];
		
		for(indexOfa=0;indexOfa<lengthOfa;indexOfa++){
			if(k<lengthOfb){
				if(a.array[indexOfa]==b.array[k]){
					unionArray[unionArrayIndex]=a.array[indexOfa];
					k++;
				}
				else if(a.array[indexOfa]>b.array[k]){
					unionArray[unionArrayIndex]=b.array[k];
					k++;
					indexOfa--;
				}
				else if(a.array[indexOfa]<b.array[k]){
					unionArray[unionArrayIndex]=a.array[indexOfa];
				}
			}
			else{
				unionArray[unionArrayIndex]=a.array[indexOfa];
			}
			unionArrayIndex++;
		}
		for(;k<lengthOfb;k++){
			unionArray[unionArrayIndex]=b.array[k];
			unionArrayIndex++;
		}
		return unionArray;
	}
}
