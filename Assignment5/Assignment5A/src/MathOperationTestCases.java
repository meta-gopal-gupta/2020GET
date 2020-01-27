import static org.junit.Assert.*;

import org.junit.Test;


public class MathOperationTestCases {
	MathOperation compute = new MathOperation();
	
	@Test
	public void evaluatesExpressionOfLCM() {
	    
	    int result = compute.LCMofXY(5, 15);
	    assertEquals(15, result);
	    
	    result = compute.LCMofXY(45, 15);
	    assertEquals(45, result);
	    
	    result = compute.LCMofXY(7, 15);
	    assertEquals(105, result);
	    
	    result = compute.LCMofXY(15, -15);
	    assertEquals(-1, result);
	    
	    result = compute.LCMofXY(15, 0);
	    assertEquals(0, result);
	   
	  }
	
	@Test
	public void evaluatesExpressionOfHCF() {
	    
	    int result = compute.HCFofXY(5, 15);
	    assertEquals(5, result);
	    
	    result = compute.HCFofXY(45, 15);
	    assertEquals(15, result);
	    
	    result = compute.HCFofXY(7, 15);
	    assertEquals(1, result);
	    
	    result = compute.HCFofXY(-45, 15);
	    assertEquals(-1, result);
	    
	    
	   
	  }
	
}
