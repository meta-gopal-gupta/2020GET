public class Poly {
	private final int polyArray[][];

	/**
	 * Constructor to initialize the polyArray
	 * @param inputArray
	 */
	public Poly(int[][] inputArray) {
		this.polyArray = inputArray;
	}

	public int[][] getPolyArray() {
		return polyArray.clone();
	}

	/**
	 * 
	 * @param inputArray
	 * @return sorted polyArray using degree
	 */
	private int[][] sorting(int[][] inputArray) {
		int tempDegree, tempCoff, lengthOfArray = inputArray.length;
		for (int leftIndex = 0; leftIndex < lengthOfArray - 1; leftIndex++)
			for (int rightIndex = 0; rightIndex < lengthOfArray - 1; rightIndex++)
				if (inputArray[rightIndex][1] < inputArray[rightIndex + 1][1]) {
					// Coefficient sorting
					tempCoff = inputArray[rightIndex + 1][0];
					inputArray[rightIndex + 1][0] = inputArray[rightIndex][0];
					inputArray[rightIndex][0] = tempCoff;
					
					
					// swap degree according to Coefficient
					tempDegree = inputArray[rightIndex + 1][1];
					inputArray[rightIndex + 1][1] = inputArray[rightIndex][1];
					inputArray[rightIndex][1] = tempDegree;
				}
		return inputArray;
	}
	/**
	 * return the value of the polynomial for the given value of the variable
	 * @param number
	 * @return
	 */
	public int evaluate(float number) {
		float totalSum = 0;
		for (int index = 0; index < polyArray.length; index++)
			totalSum += polyArray[index][0] * Math.pow(number, polyArray[index][1]);
		return (int) totalSum;
	}

	
	/**
	 * - return the degree of the polynomial
	 * @return
	 */
	public int degree() {
		int[][] arr = sorting(this.polyArray);
		return arr[0][1];
	}

	
	/**
	 * 
	 * @param firstPolynomail
	 * @param secondPolynomial
	 * @return return the sum of the polynomials firstPolynomail and secondPolynomial
	 */
	public int[][] addPoly(Poly firstPolynomail, Poly secondPolynomial) {
		int firstSortedPolinomial[][] = sorting(firstPolynomail.polyArray);
		int firstPolinomialIndex = 0;
		int secondPolynomialIndex = 0, resultPolinomialIndex = 0;
		int[][] secondSortedPolinomial = sorting(secondPolynomial.polyArray);
		int resultantPolinomial[][] = new int[firstSortedPolinomial.length + secondSortedPolinomial.length][2];

		while (firstPolinomialIndex < firstSortedPolinomial.length && secondPolynomialIndex < secondSortedPolinomial.length) {
			if (firstSortedPolinomial[firstPolinomialIndex][1] == secondSortedPolinomial[secondPolynomialIndex][1]) {
				resultantPolinomial[resultPolinomialIndex][0] = firstSortedPolinomial[firstPolinomialIndex][0] + secondSortedPolinomial[secondPolynomialIndex][0];
				resultantPolinomial[resultPolinomialIndex][1] = firstSortedPolinomial[firstPolinomialIndex][1];
				firstPolinomialIndex++;
				resultPolinomialIndex++;
				secondPolynomialIndex++;
			}
			else if (firstSortedPolinomial[firstPolinomialIndex][1] > secondSortedPolinomial[secondPolynomialIndex][1]) {
				resultantPolinomial[resultPolinomialIndex][0] = firstSortedPolinomial[firstPolinomialIndex][0];
				resultantPolinomial[resultPolinomialIndex][1] = firstSortedPolinomial[firstPolinomialIndex][1];
				firstPolinomialIndex++;
				resultPolinomialIndex++;
			}
			else {
				resultantPolinomial[resultPolinomialIndex][0] = secondSortedPolinomial[secondPolynomialIndex][0];
				resultantPolinomial[resultPolinomialIndex][1] = secondSortedPolinomial[secondPolynomialIndex][1];
				resultPolinomialIndex++;
				secondPolynomialIndex++;
			}
		}

		while (firstPolinomialIndex < firstSortedPolinomial.length) {
			resultantPolinomial[resultPolinomialIndex][0] = firstSortedPolinomial[firstPolinomialIndex][0];
			resultantPolinomial[resultPolinomialIndex][1] = firstSortedPolinomial[firstPolinomialIndex][1];
			resultPolinomialIndex++;
			firstPolinomialIndex++;
		}
		while (secondPolynomialIndex < secondSortedPolinomial.length) {
			resultantPolinomial[resultPolinomialIndex][0] = secondSortedPolinomial[secondPolynomialIndex][0];
			resultantPolinomial[resultPolinomialIndex][1] = secondSortedPolinomial[secondPolynomialIndex][1];
			secondPolynomialIndex++;
			resultPolinomialIndex++;
		}
		return resultantPolinomial ;
	}

	/**
	 * 
	 * @param firstPolynomail
	 * @param secondPolynomail
	 * @return -return the product of polynomials p1 and p2 
	 */
	public int[][] multiplyPoly(Poly firstPolynomail, Poly secondPolynomail) {
		int firstSortedPolinomial[][] = sorting(firstPolynomail.polyArray), coefficient = 0, power = 0;
		int[][] secondSortedPolinomial = sorting(secondPolynomail.polyArray);
		int totalSize = firstSortedPolinomial[0][1] + secondSortedPolinomial[0][1];
		int resultantPolinomial[][] = new int[totalSize + 1][2];
		for (int firstPolinomailIndex = 0; firstPolinomailIndex < firstSortedPolinomial.length; firstPolinomailIndex++)
			for (int secondPolinomialIndex = 0; secondPolinomialIndex < secondSortedPolinomial.length; secondPolinomialIndex++) {
				coefficient = firstSortedPolinomial[firstPolinomailIndex][0] * secondSortedPolinomial[secondPolinomialIndex][0];
				power = firstSortedPolinomial[firstPolinomailIndex][1] + secondSortedPolinomial[secondPolinomialIndex][1];
				resultantPolinomial[power][0] += coefficient;
				resultantPolinomial[power][1] = power;
			}
		
		return resultantPolinomial;
	}
}