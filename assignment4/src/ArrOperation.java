public class ArrOperation {
/**
 * 
 * @param inputArray 
 * @return maxMirrorInArray which is number of max mirror element in array
 * Dynamic Programming 
 */
	public static int maxMirror(int[] inputArray) {
		int sizeOfArray = inputArray.length;

		int[][] positiveIntegerArray = new int[sizeOfArray + 1][sizeOfArray + 1];
		int maxMirrorInArray = 0;

		for (int outerIndex = 0; outerIndex <= sizeOfArray; outerIndex++) {
			for (int innerIndex = 0; innerIndex <= sizeOfArray; innerIndex++) {
				if (outerIndex == 0 || innerIndex == 0)
					positiveIntegerArray[outerIndex][innerIndex] = 0;
				else if (inputArray[outerIndex - 1] == inputArray[sizeOfArray - innerIndex]) {
					positiveIntegerArray[outerIndex][innerIndex] = positiveIntegerArray[outerIndex - 1][innerIndex - 1] + 1;
					maxMirrorInArray = Math.max(maxMirrorInArray, positiveIntegerArray[outerIndex][innerIndex]);
				}
				else
					positiveIntegerArray[outerIndex][innerIndex] = 0;
			}
		}
		return maxMirrorInArray;
	}
	/**
	 * 
	 * @param inputArray 
	 * @return number of clumps in array
	 * Clump in an array is a series of 2 or more adjacent elements of the same value
	 */
	public static int countClumps(int[] inputArray) {
		int sizeOfArray = inputArray.length;
		int clumpCount = 0;
		int z = inputArray[0];
		if (inputArray[0] == inputArray[1])
			clumpCount++;
		for (int index = 1; index < sizeOfArray; index++) {
			if (inputArray[index] == inputArray[index - 1]) {
				if (z != inputArray[index - 1]) {
					clumpCount++;
					z = inputArray[index - 1];
				}
			}
		}
		return clumpCount;
	}
/**
 * 
 * @param inputArray,X,Y
 * @return integer array that contains exactly the same numbers as the input array, but rearranged so that 
 * every X is immediately followed by a Y. Do not move X within array, but every other number may move 
 */
	public static int[] fixXY(int[] inputArray,int X, int Y) {
		int sizeOfArray = inputArray.length, swapVariable;

		for (int outerIndex = 0; outerIndex < sizeOfArray - 1; outerIndex++) {
			if (inputArray[outerIndex] == X && inputArray[outerIndex + 1] != Y)
				for (int innerIndex = 1; innerIndex < sizeOfArray; innerIndex++) {
					if (inputArray[0] == Y) {
						swapVariable = inputArray[0];
						inputArray[0] = inputArray[outerIndex + 1];
						inputArray[outerIndex + 1] = swapVariable;
						break;
					}
					if (inputArray[innerIndex] == Y && inputArray[innerIndex - 1] != X) {
						swapVariable = inputArray[innerIndex];
						inputArray[innerIndex] = inputArray[outerIndex + 1];
						inputArray[outerIndex + 1] = swapVariable;
						break;
					}
				}
		}
		return inputArray;
	}
/**
 * 
 * @param input Array
 * @return Return the index if there is a place to split the input array so that the sum of the numbers on one 
 * side is equal to the sum of the numbers on the other side else return -1
 */
	public static int splitArray(int[] inputArray) {
		int sizeOfArray = inputArray.length, temp = -1,even = 0;
		int splitedSum = 0, totalSum = 0, index;
		for (index = 0; index < sizeOfArray; index++) {
			splitedSum += inputArray[index];
		}
		if (splitedSum % 2 == even) {
			for (index = 0; index < sizeOfArray; index++) {
				totalSum += inputArray[index];
				if (totalSum == splitedSum / 2) {
					temp = index + 1;
					break;
				}
			}
		}

		return temp;
	}
}