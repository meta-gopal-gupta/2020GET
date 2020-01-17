import static org.junit.Assert.*;

import org.junit.Test;


public class ArrOperationTest {
	//Test Case Of count clumps function
	@Test
	public void evaluatesExpressionOfCountClumps() {
	    
	    int result = ArrOperation.countClumps(new int[] {1,1,2,2,3,4,4});
	    assertEquals(3, result);
	    
	    result = ArrOperation.countClumps(new int[] {1,2,2,3,4});
	    assertEquals(1, result);
	    
	    result = ArrOperation.countClumps(new int[] {1,2,2,3,4});
	    assertEquals(1, result);
	    
	    result = ArrOperation.countClumps(new int[] {1,2,2,3,3,3,3,4,4,3,3});
	    assertEquals(4, result);
	  }
	
	// Test Cases of Max Mirror function
	@Test
	public void evaluateExpressionMaxMirror(){
		int result ;
		result = ArrOperation.maxMirror(new int[] {1,2,3,8,9,3,2,1});
		assertEquals(3, result);
		
		result = ArrOperation.maxMirror(new int[] {7,1,4,9,7,4,1});
		assertEquals(2, result);
		
		result = ArrOperation.maxMirror(new int[] {1,2,1,4});
		assertEquals(3, result);
	}
	
	// Test Cases of Split Array function
	@Test
	public void evaluatesExpressionSplitArray(){
		int result ;
		result = ArrOperation.splitArray(new int[] {1,1,1,2,1});
		assertEquals(3, result);
		
		result = ArrOperation.splitArray(new int[] {2,1,1,2,1});
		assertEquals(-1, result);
		
		result = ArrOperation.splitArray(new int[] {10,10});
		assertEquals(1, result);
	}
	
	// Test Cases of FixXY function
	@Test
	public void evaluatesExpressionFixXY(){
		int[] result  ;
		
		result = ArrOperation.fixXY(new int[] {5,4,9,4,5,9}, 4, 5);
		assertArrayEquals(new int[] {9,4,5,4,5,9}, result);

		result = ArrOperation.fixXY(new int[] {1,4,1,3},4,3);
		assertArrayEquals(new int[] {1,4,3,1}, result);

		result = ArrOperation.fixXY(new int[] {1,8,1,5,5,8,1},8,5);
		assertArrayEquals(new int[] {1,8,5,1,1,8,5}, result);
	}
	
}