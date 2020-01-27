public class NQueensOperation {

	/**
	 * 
	 * @param chessBoard 2D Matrix of Chess Board
	 * @param boardSize  Length Of Board
	 * @return NQueens Correct location array
	 */
	int[][] NQueensSolution(int[][] chessBoard,int boardSize){
		int row =0;				//  starting row
		
		if(NQProblem(chessBoard,row,boardSize));
		
		return chessBoard;
	}
	
	/**
	 * 
	 * @param chessBoard 2D Matrix of Chess Board
	 * @param row  row Of the Chess Board 
	 * @param boardSize  Length Of Board
	 * @return true if all queens are placed correctly
	 */
	boolean NQProblem(int[][] chessBoard,int row,int boardSize){
		if(row>=boardSize) return true;
		for(int i=0;i<boardSize;i++){
			
			// To check that current location is safe or not
			if(isSafe(chessBoard, row, i,boardSize)){
				
				// If correct then place queen there
				chessBoard[row][i]=1;
				
				// Call function again for next coloumn
				if(NQProblem(chessBoard,row+1,boardSize)){
					return true;
				}
				
				// if no location for next queen then remove queen from there
				chessBoard[row][i]=0;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param chessBoard 
	 * @param row current row
	 * @param col current column
	 * @param boardSize
	 * @return true if current location is safe
	 */
	boolean isSafe(int[][] chessBoard,int row,int col,int boardSize){
		int index;
		
		// to check in respective row and column
		for(index=0;index<boardSize;index++){
			if(chessBoard[index][col]==1||chessBoard[row][index]==1){
				return false;
			}
		}
		
		// to check diagonally with respect to current location
		for(int rowIndex=0;rowIndex<boardSize;rowIndex++){
			for(int columnIndexj=0;columnIndexj<boardSize;columnIndexj++){
				if(rowIndex-columnIndexj == row-col || rowIndex+columnIndexj == row + col){
					if(chessBoard[rowIndex][columnIndexj]==1){
						return false;
					}
				}
			}
		}
		return true;
	}
}
