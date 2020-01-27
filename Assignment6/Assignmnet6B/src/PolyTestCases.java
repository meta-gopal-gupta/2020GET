import static org.junit.Assert.*;

import org.junit.Test;


public class PolyTestCases {

	Poly obj = new Poly(new int[][]{{2,1},{2,2},{2,0}});

	@Test
	public void when_onefloat_passed() {
		assertEquals(14, obj.evaluate(2.0f));
	}

	@Test
	public void when_onefloat_passed1() {
		assertEquals(6, obj.evaluate(-2f));
	}
	
	@Test
	public void degree_of_polynomial() {
		assertEquals(2, obj.degree());
	}
	
	@Test
	public void when_two_oject_passed() {
		assertArrayEquals( new int[][]{{2,4},{2,2},{4,1},{2,1},{0,0}}, obj.addPoly( new Poly(new int[][]{{2,1},{2,2},{2,4}}), new Poly(new int[][]{{2,1},{2,1}})) );
	}
	
	@Test
	public void when_two_oject_passed1() {
		assertArrayEquals( new int[][]{{0,0},{0,0},{8,2},{8,3},{0,0},{8,5}}, obj.multiplyPoly( new Poly(new int[][]{{2,1},{2,2},{2,4}}), new Poly(new int[][]{{2,1},{2,1}})) );
	}
	

}
