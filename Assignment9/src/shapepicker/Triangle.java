package shapepicker;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements shape interface.
 * @author Gopal
 *
 */
public class Triangle implements Shape {
	private String type = typeOfShape.TRIANGLE.toString();
	private double width,height;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	public Triangle(StartingPoint obj, ArrayList<Double> listOfInteger){
		width = listOfInteger.get(0);
		height = listOfInteger.get(1);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = (width*height)/2;
		perimeter = 2*(width + height);
		originDistance = Math.sqrt(Math.pow(coordinates.xCoordinate, 2) + Math.pow(coordinates.yCoordinate, 2));
		Date date= new Date();
		long time = date.getTime();
		tstamp = new Timestamp(time);
	}

	@Override
	public double getArea() {
		return area;
	}

	@Override
	public StartingPoint getOrigin() {
		return coordinates;
	}

	@Override
	public double getPerimeter() {
		return perimeter;
	}

	@Override
	public boolean isPointEnclosed(StartingPoint startPoint) {
		if(startPoint.xCoordinate >= coordinates.xCoordinate && startPoint.xCoordinate <= coordinates.xCoordinate+width
				&& startPoint.yCoordinate >= coordinates.yCoordinate && startPoint.yCoordinate <= coordinates.yCoordinate+width)
			return true;
		return false;
	}

	@Override
	public String getShapeType() {
		return type;
	}

	@Override
	public Timestamp getTimeStamp() {
		return tstamp;
	}
}
