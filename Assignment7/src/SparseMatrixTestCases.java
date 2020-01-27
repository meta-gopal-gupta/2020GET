import static org.junit.Assert.*;
import org.junit.Test;

public class SparseMatrixTestCases {
	@Test
	public void transposeOfMatrixSimpleTestCase() {
		SparseMatrix sparse = new SparseMatrix( new int[][]{{1,1,1},{1,0,6},{0,0,11}},4,4);
		assertEquals( true, sparse.transposeOfMatrix());
	}
	
	@Test
	public void symmetryOfMatrixPositiveTestCase() {
		SparseMatrix sparse = new SparseMatrix( new int[][]{{1,1,1},{1,0,5},{2,3,4}},4,4);
		assertEquals(false, sparse.isMatrixSymmetric());
	}

	@Test
	public void symmetryOfMatrixNegativeTestCase() {
		SparseMatrix sparse = new SparseMatrix( new int[][]{{0,1,5},{1,0,5},{3,3,8}},4,4);
		assertEquals(true, sparse.isMatrixSymmetric());
	}

	@Test
	public void symmetryOfMatrixUnequalRowAndColumnTestCase() {
		SparseMatrix sparse = new SparseMatrix( new int[][]{{0,1,5},{1,0,5},{3,3,8}},4,5);
		assertEquals(false, sparse.isMatrixSymmetric());
	}

	@Test
	public void additionOfSparseMatricesPositiveTestCase() {
		SparseMatrix sparse1 = new SparseMatrix( new int[][]{{1,1,1},{0,3,4},{3,1,9}},4,4 );
		SparseMatrix sparse2 = new SparseMatrix( new int[][]{{1,0,5},{1,2,9},{1,3,9}},4,4 );
		assertEquals( true, sparse1.additionOfSparseMatrix(sparse2));
	}

	@Test
	public void additionOfSparseMatricesNegativeTestCase() {
		SparseMatrix sparse1 = new SparseMatrix( new int[][]{{1,1,5},{0,2,8},{3,3,9}},5,4 );
		SparseMatrix sparse2 = new SparseMatrix( new int[][]{{1,1,3},{0,3,7},{2,2,9}},4,6 );
		assertEquals( false, sparse1.additionOfSparseMatrix(sparse2));
	}
	
	@Test
	public void multiplicationOfSparseMatricesPositiveTestCase() {
		SparseMatrix sparse1 = new SparseMatrix( new int[][]{{1,1,5},{0,2,8},{3,3,9}},5,4 );
		SparseMatrix sparse2 = new SparseMatrix( new int[][]{{1,1,3},{0,3,7},{2,2,9}},4,6 );
		assertEquals(true , sparse1.multipliactionOfSparseMatrix(sparse2));
	}
	
	@Test
	public void multiplicationOfSparseMatricesNegativeTestCase() {
		SparseMatrix sparse1 = new SparseMatrix( new int[][]{{1,1,0},{0,2,2},{2,1,9}},3,7 );
		SparseMatrix sparse2 = new SparseMatrix( new int[][]{{1,1,0},{0,3,1},{1,0,9}},4,6 );
		assertEquals(false , sparse1.multipliactionOfSparseMatrix(sparse2));
	}
}