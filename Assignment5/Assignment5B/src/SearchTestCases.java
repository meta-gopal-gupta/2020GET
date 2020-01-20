import static org.junit.Assert.*;

import org.junit.Test;


public class SearchTestCases {
	SearchMain sort = new SearchMain();
	
	@Test
	public void evaluateExpressionOfLinearSearch() {
		int result;
		
		result = sort.linearSearch(new int[] {11,13,17,25,31,37,43,64,81,90,100},64,0);
		assertEquals(7,result);
		
		result = sort.linearSearch(new int[] {11,13,17,25,31,37,43,64,81,90,100},11,0);
		assertEquals(0,result);
		
		result = sort.linearSearch(new int[] {11,13,17,25,31,37,43,64,81,90,100},100,0);
		assertEquals(10,result);
		
		result = sort.linearSearch(new int[] {2,5,8,4,9,7},0,0);
		assertEquals(-1,result);
		
		result = sort.linearSearch(new int[] {1,1,1,1,1,1,1},1,0);
		assertEquals(0,result);
		
		result = sort.linearSearch(new int[] {1},2,0);
		assertEquals(-1,result);
		
		result = sort.linearSearch(new int[] {},1,0);
		assertEquals(-1,result);
	}
	
	@Test
	public void evaluateExpressionOfBinarySearch() {
		int result;
		
		result = sort.linearSearch(new int[] {11,13,17,25,31,37,43,64,81,90,100},64,0);
		assertEquals(7,result);
		
		result = sort.linearSearch(new int[] {11,13,17,25,31,37,43,64,81,90,100},11,0);
		assertEquals(0,result);
		
		result = sort.linearSearch(new int[] {11,13,17,25,31,37,43,64,81,90,100},100,0);
		assertEquals(10,result);
		
		result = sort.linearSearch(new int[] {2,5,8,4,9,7},0,0);
		assertEquals(-1,result);
		
		result = sort.linearSearch(new int[] {1,1,1,1,1,1,1},1,0);
		assertEquals(0,result);
		
		result = sort.linearSearch(new int[] {1},2,0);
		assertEquals(-1,result);
		
		result = sort.linearSearch(new int[] {},1,0);
		assertEquals(-1,result);	
	}

}
