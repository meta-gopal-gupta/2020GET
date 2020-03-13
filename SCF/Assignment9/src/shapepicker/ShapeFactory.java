package shapepicker;

import java.util.ArrayList;

/**
 * This factory is used to decide which object is needed to be created based on shape type.
 * @author Gopal
 *
 */
public class ShapeFactory {
	public static Shape typeShapeFactory(String shapeType, StartingPoint coordinate, ArrayList<Double> shapeDetails){
		Shape obj = null;
		if(Shape.typeOfShape.SQUARE.toString().equalsIgnoreCase(shapeType))
			obj = new Square(coordinate,shapeDetails);
		else if(Shape.typeOfShape.RECTANGLE.toString() == shapeType)
			obj = new Rectangle(coordinate,shapeDetails);
		else if(Shape.typeOfShape.TRIANGLE.toString() == shapeType)
			obj = new Triangle(coordinate,shapeDetails);
		else if(Shape.typeOfShape.CIRCLE.toString() == shapeType)
			obj = new Circle(coordinate,shapeDetails);
		return obj;
	}
}
