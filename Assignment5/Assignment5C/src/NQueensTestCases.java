import static org.junit.Assert.*;

import org.junit.Test;


public class NQueensTestCases {
	NQueensOperation NQSolution = new NQueensOperation();
	
	@Test
	public void evaluatesExpressionNQueensSolution(){
		int[][] result  ;
		
		result = NQSolution.NQueensSolution(new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, 4);   
		assertArrayEquals(new int[][] {{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}}, result);
		
		result = NQSolution.NQueensSolution(new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}, 5);   
		assertArrayEquals(new int[][] {{1,0,0,0,0},{0,0,1,0,0},{0,0,0,0,1},{0,1,0,0,0},{0,0,0,1,0}}, result);
		
		//if NQueens Solution not exist then return all Zero Matrix
		result = NQSolution.NQueensSolution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}, 3);   
		assertArrayEquals(new int[][] {{0,0,0},{0,0,0},{0,0,0}}, result);
		
	}

}
