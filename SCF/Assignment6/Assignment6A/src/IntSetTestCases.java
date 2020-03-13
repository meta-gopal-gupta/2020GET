import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class IntSetTestCases {

	IntSet intset1; 
	IntSet intset2;
	IntSet intset3;
	IntSet intset4;
	@Before
	public void beforeTest()
	{
		intset1 = new IntSet(new int []{0,1,2,3,4,5,6,7,8,9,10,11});
		intset2 = new IntSet(new int[]{0,1,2,3,4});
		intset3 = new IntSet(new int[]{3,4,5,6});
		intset4 = new IntSet(new int[]{1,2,3,4,5});

	}
	@Test
	public void testIsMember()
	{
		boolean result = intset1.isMember(11);
		assertEquals(true,result);
		result = intset1.isMember(100);
		assertEquals(false,result);

	}

	@Test
	public void testSize()
	{
		int result = intset1.size();
		assertEquals(12,result);
		result = intset2.size();
		assertEquals(5,result);

	}
	
	@Test
	public void testIsSubset()
	{
		boolean result = intset1.isSubSet(intset2);
		assertEquals(true, result);
		result = intset2.isSubSet(intset3);
		assertEquals(false, result);
		result = intset1.isSubSet(intset3);
		assertEquals(true, result);
		
	}
	@Test
	public void testGetCompliment()
	{
		int result[] = intset4.getComplement();
		int expected[] = new int[995];
		int index =0 ;
		for(int i=6;i<=1000;i++)
		{
			expected[index] = i; 
			index++;
		}
		assertArrayEquals(expected,result);
		
	}
	
	@Test 
	public void testGetUnion()
	{
		int[] union = intset1.union(intset2, intset3);
		assertArrayEquals(new int[]{0,1,2,3,4,5,6}, union);
	}
	

}
