package shapepicker;

import java.util.*;

/**
 * This class contains operation to be performed on Shapes.
 * @author Gopal
 *
 */
public class Screen{
	private ArrayList<Shape> listOfShape = new ArrayList<Shape>();

	/**
	 * This function creates and adds new shape in a listOfShape list.
	 * @param type of shape.
	 * @param xCoordinate starting x-coordinate
	 * @param yCoordinate starting y-coordinate
	 * @param length sides length of shape
	 * @return true if shape is added else false.
	 * @throws AssertionError when parameters are invalid.
	 */
	public boolean addShape(String type,double xCoordinate,double yCoordinate,ArrayList<Double> length) throws AssertionError{
		if(type == null|| xCoordinate < 0|| yCoordinate < 0|| length.size() <= 0)
			throw new AssertionError("Provide valid parameters.");
		StartingPoint startPoint = new StartingPoint(xCoordinate,yCoordinate);
		Shape shapeObj = ShapeFactory.typeShapeFactory(type, startPoint, length);
		listOfShape.add(shapeObj);
		return true;
	}

	/**
	 * This function removes all shapes of same type.
	 * @param shapeType of object to be removed.
	 * @return true if shape found else false.
	 */
	public boolean removeAllShapesOfSameType(String shapeType){
		int index;
		for(index=0; index < listOfShape.size();index++){
			if(listOfShape.get(index).getShapeType().equalsIgnoreCase(shapeType))
				listOfShape.remove(index);
		}
		if(listOfShape.size() < index)
			return true;
		else 
			return false;
	}


	/**
	 * This function checks is the provided corrdinates are enclosed by any shape or not.
	 * @param xCoord coordinate of point.
	 * @param yCoord coordinate of point.
	 * @return list of objects enclosing the point.
	 * @throws AssertionError if no object found enclosing the shape.
	 */
	public ArrayList<Shape> checkShapesEnclosingPoint(double xCoord, double yCoord) throws AssertionError{
		StartingPoint startPoint = new StartingPoint(xCoord,yCoord);

		ArrayList<Shape> enclosingShapeObjects = new ArrayList<Shape>();

		for(int index = 0; index<listOfShape.size();index++){
			if(listOfShape.get(index).isPointEnclosed(startPoint))
				enclosingShapeObjects.add(listOfShape.get(index));
		}

		if(enclosingShapeObjects.size() == 0)
			throw new AssertionError("No object enclosing this point found.");

		return enclosingShapeObjects;
	}

	/**
	 * This function removes shape from screen.
	 * @param shapeType object type to be removed.
	 * @return true if shape removed else false.
	 */
	public boolean removeShape(String shapeType){
		for(int iindex=0; iindex < listOfShape.size();iindex++){
			if(listOfShape.get(iindex).getShapeType().equalsIgnoreCase(shapeType)){
				listOfShape.remove(iindex);
				return true;
			}
		}
		return false;
	}

		public static void main(String[] args){
		Screen screen = new Screen();
		ArrayList<Double> sides = new ArrayList<Double>();
		sides.add(5d);
		screen.addShape("square", 5d, 7d, sides);
		System.out.println(screen.listOfShape.get(0).getShapeType());
		System.out.println(screen.listOfShape.get(0).getTimeStamp());
		System.out.println(screen.listOfShape.get(0).getArea());
		System.out.println(screen.listOfShape.get(0).getOrigin().xCoordinate+","+screen.listOfShape.get(0).getOrigin().yCoordinate);
		System.out.println("----------------");
		
		sides.add(4d);
		screen.addShape("rectangle", 2d, 7d, sides);
		System.out.println(screen.listOfShape.get(1).getShapeType());
		System.out.println(screen.listOfShape.get(1).getTimeStamp());
		System.out.println(screen.listOfShape.get(1).getArea());
		System.out.println(screen.listOfShape.get(1).getOrigin().xCoordinate+","+screen.listOfShape.get(1).getOrigin().yCoordinate);
		System.out.println("----------------");

		sides.add(3d);
		screen.addShape("triangle", 8d, 3d, sides);
		System.out.println(screen.listOfShape.get(2).getShapeType());
		System.out.println(screen.listOfShape.get(2).getTimeStamp());
		System.out.println(screen.listOfShape.get(2).getArea());
		System.out.println(screen.listOfShape.get(2).getOrigin().xCoordinate+","+screen.listOfShape.get(2).getOrigin().yCoordinate);
		System.out.println("----------------");

		ArrayList<Double> radius = new ArrayList<Double>();
		radius.add(4d);
		screen.addShape("circle", 4d, 4d, radius);
		System.out.println(screen.listOfShape.get(3).getShapeType());
		System.out.println(screen.listOfShape.get(3).getTimeStamp());
		System.out.println(screen.listOfShape.get(3).getArea());
		System.out.println(screen.listOfShape.get(3).getOrigin().xCoordinate+","+screen.listOfShape.get(3).getOrigin().yCoordinate);
		System.out.println("----------------");

		ArrayList<Shape> enclodedShapes = new ArrayList<Shape>();
		enclodedShapes = screen.checkShapesEnclosingPoint(3d, 6d);
		for(int i=0;i<enclodedShapes.size();i++){
			System.out.println(enclodedShapes.get(i).getShapeType());
		}		
		System.out.println("\n\n\n\n----------------");
		enclodedShapes = screen.checkShapesEnclosingPoint(6d, 8d);
		for(int i=0;i<enclodedShapes.size();i++){
			System.out.println(enclodedShapes.get(i).getShapeType());
		}		

		}
}

