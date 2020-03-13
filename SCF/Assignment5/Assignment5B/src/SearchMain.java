
public class SearchMain {
	/**
	 * 
	 * @param array   unsorted array
	 * @param searchValue Search in array
	 * @param index Current Index (Starting value =0)
	 * @return Index of searchValue
	 * 
	 * Always return first matched location 
	 * Whenever value not exist in array return -1
	 */
	public int linearSearch(int[] array,int searchValue, int index){
		int length = array.length;
		if(length > index){
			if(array[index]==searchValue){
				return index;
			}
			else{
				return linearSearch(array,searchValue,index+1);
			}
		}
		return -1;
	}
	
	
	/**
	 * 
	 * @param sortedArray
	 * @param lowerIndex (initially 0)
	 * @param upperIndex (initially MAX_INDEX)
	 * @param searchValue
	 * @return Index of searchValue
	 * 
	 * Always return first matched location 
	 * Whenever value not exist in array return -1
	 */
	public int binarySearch(int[] sortedArray,int lowerIndex, int upperIndex,int searchValue){
		int middleIndex = (lowerIndex+upperIndex)/2;
		if(upperIndex-lowerIndex<0) return -1;
		if(sortedArray[middleIndex]==searchValue){
			return middleIndex;
		}
		else if(sortedArray[middleIndex]<searchValue) return binarySearch(sortedArray,middleIndex+1,upperIndex,searchValue);
		else return binarySearch(sortedArray,lowerIndex,middleIndex-1,searchValue);
		
	}

}
