package shapepicker;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements shape interface.
 * @author gopal
 *
 */
public class Circle implements Shape {
	private String type = typeOfShape.CIRCLE.toString();
	private double radius;
	private StartingPoint coordinates;
	private double area, perimeter,originDistance;
	private Timestamp tstamp;

	public Circle(StartingPoint obj, ArrayList<Double> listOfInteger){
		radius = listOfInteger.get(0);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = Math.PI*Math.pow(radius,2);
		perimeter = 2*Math.PI*radius;
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
		if( Math.sqrt(Math.pow(startPoint.xCoordinate - coordinates.xCoordinate, 2) + Math.pow(startPoint.xCoordinate - coordinates.yCoordinate, 2)) <= radius)
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
