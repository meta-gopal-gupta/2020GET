class SparseMatrix{
	public final int[][] sparseMarix;
	public final int rowSize;
	public final int colSize;
	
	/**
	 * 
	 * @param sparseMatrix
	 * @param rowSize
	 * @param colSize
	 * Constructor to initialize the variables
	 */
	SparseMatrix(int[][] sparseMatrix,int rowSize,int colSize){
		if(!isMatrixCorrect(sparseMatrix,rowSize,colSize)){
			System.out.println("Incorrect");
		}
		this.sparseMarix=sparseMatrix;
		this.rowSize=rowSize;
		this.colSize=colSize;
	}
	
	/**
	 * 
	 * @param sparseMatrix
	 * @param rowSize
	 * @param colSize
	 * @return true if matrix is correct
	 * return false when row or col is greater then the index size
	 */
	boolean isMatrixCorrect(int[][] sparseMatrix,int rowSize, int colSize){
		for(int row=0;row<sparseMatrix.length;row++){
			for(int col=row+1;col<sparseMatrix.length;col++){
				if(sparseMatrix[row][0]==sparseMatrix[col][0] && sparseMatrix[row][1]==sparseMatrix[col][1]){
					return false;
				}
			}
			if(rowSize<=sparseMatrix[row][0] || colSize<=sparseMatrix[row][1]){
				return false;
			}	
		}
		
		
		return true;
	}
	
	
	/**
	 * 
	 * @return true and print the transpose of matrix
	 */
	boolean transposeOfMatrix(){
		int[][] matrix = new int[this.rowSize][this.colSize];
		for(int row=0;row<this.sparseMarix.length;row++){
			matrix[this.sparseMarix[row][1]][this.sparseMarix[row][0]] = this.sparseMarix[row][2];
		}
		
		for(int row=0;row<this.rowSize;row++){
			for(int col=0;col<this.colSize;col++){
				System.out.print(" "+matrix[row][col]);
			}
			System.out.println();
		}
		return true;
	}
	
	
	/**
	 * 
	 * @return true if matrix is symmetric 
	 */
	boolean isMatrixSymmetric(){
		if(this.rowSize!=this.colSize){
			return false;
		}
		int[][] matrix = new int[this.rowSize][this.colSize];
		for(int row=0;row<this.sparseMarix.length;row++){
			matrix[this.sparseMarix[row][0]][this.sparseMarix[row][1]] = this.sparseMarix[row][2];
		}
		for(int row=0;row<this.rowSize;row++){
			for(int col=0;col<this.colSize;col++){
				if(matrix[row][col]!=matrix[col][row]){
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * 
	 * @param sparse2
	 * @return true if matrix addition is possible
	 * and print the addition of the matrix 
	 */
	boolean additionOfSparseMatrix(SparseMatrix sparse2){
		if(!isMatrixAdditionPossible(sparse2.rowSize,sparse2.colSize)){
			System.out.println("not possible");
			return false;
		}
		int[][] matrix = new int[sparse2.rowSize][sparse2.colSize];
		for(int row=0;row<this.sparseMarix.length;row++){
			matrix[this.sparseMarix[row][0]][this.sparseMarix[row][1]] += this.sparseMarix[row][2];
		}
		for(int row=0;row<sparse2.sparseMarix.length;row++){
			matrix[sparse2.sparseMarix[row][0]][sparse2.sparseMarix[row][1]] += sparse2.sparseMarix[row][2];
		}
		
		for(int row=0;row<sparse2.rowSize;row++){
			for(int col=0;col<sparse2.colSize;col++){
				System.out.print(" "+matrix[row][col]);
			}
			System.out.println();
		}
		
		
		return true;
	}
	
	
	/**
	 * 
	 * @param rowSize
	 * @param colSize
	 * @return true if both matrix sizes are same
	 */
	boolean isMatrixAdditionPossible(int rowSize,int colSize){
		if(this.rowSize==rowSize && this.colSize==colSize){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param sparse2
	 * @return true if multiplication is possible and
	 * print the multiplied matrix
	 */
	boolean multipliactionOfSparseMatrix(SparseMatrix sparse2){
		if(!isMatrixMultipicationPossible(sparse2.rowSize)){
			System.out.println("not possible");
			return false;
		}
		int[][] matrix = new int[sparse2.rowSize][sparse2.colSize];
		for(int row=0;row<this.sparseMarix.length;row++){
			for(int col=0;col<sparse2.sparseMarix.length;col++){
				if(this.sparseMarix[row][1]==sparse2.sparseMarix[col][0]){
					matrix[this.sparseMarix[row][0]][sparse2.sparseMarix[col][1]] += this.sparseMarix[row][2]* sparse2.sparseMarix[col][2];
				}				
			}
		}
		
		
		for(int row=0;row<sparse2.rowSize;row++){
			for(int col=0;col<sparse2.colSize;col++){
				System.out.print(" "+matrix[row][col]);
			}
			System.out.println();
		}
		
		
		return true;
	}
	
	/**
	 * 
	 * @param rowSize
	 * @return true if multiplication is possible
	 * it will check col of first matrix and row of second matrix is 
	 * same or not
	 */
	boolean isMatrixMultipicationPossible(int rowSize){
		if(this.colSize==rowSize){
			return true;
		}
		return false;
	}
	
	
	
}
