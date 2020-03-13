
public class Area{
	
	int charToIntConversion(String option){
		int wrongOption = 8;
		if(option.length()>1){
			return wrongOption;
		}
		int integerValue = option.charAt(0) - 48;
		return integerValue;
	}
	/*
	 * @Param width and height - only numeric value(Double)
	 * @return Area of triangle
	 * 
	 */
	double areaOfTriangle(double width, double height){
		double areaOfTriangle;
		areaOfTriangle = (width*height)/2;
		return areaOfTriangle;
	}
	
	
	/*
	 * @Param width and height - only numeric value(Double)
	 * @return Area of rectangle
	 * 
	 */
	double areaOfRectangle(double width, double height){
		double areaOfRectangle;
		areaOfRectangle = (width*height);
		return areaOfRectangle;
	}
	
	
	/*
	 * @Param width - only numeric value(Double)
	 * @return Area of Square
	 * 
	 */
	double areaOfSquare(double width){
		double areaOfSquare;
		areaOfSquare = (width*width);
		return areaOfSquare;
	}
	
	
	/*
	 * @Param radius - only numeric value(Double)
	 * @return Area of Circle
	 * 
	 */
	double areaOfCircle(double radius){
		double pi = 22.0/7.0;
		double areaOfCircle;
		areaOfCircle =  pi * radius * radius;
		return areaOfCircle;
	}
}
