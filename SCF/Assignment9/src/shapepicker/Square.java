package shapepicker;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class implements shape interface.
 * @author Gopal
 */
public class Square implements Shape {
	private String type = typeOfShape.SQUARE.toString();
	private double width;
	private StartingPoint coordinates;
	private double area, perimeter;
	private Timestamp tstamp;

	public Square(StartingPoint obj, ArrayList<Double> listOfInteger){
		width = listOfInteger.get(0);
		coordinates = new StartingPoint(obj.xCoordinate, obj.yCoordinate);
		area = width*width;
		perimeter = 4*width;
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
	public boolean isPointEnclosed(StartingPoint startPoint){
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
