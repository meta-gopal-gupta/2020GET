import java.util.Scanner;

/*
 * @author Gopal Gupta
 * Program to find area of different shapes 
 * 
 */
public class ShapeMain {

	public static void main(String[] args) {

		System.out.println("--------------------------------------------------------------------------");
		System.out.println("|  Program to find area of different shapes                              |");
		System.out.println("|  Note:  height,  width  and  radius  will  be  greater  than  zero     |");
		System.out.println("--------------------------------------------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		Area compute = new Area();
		
		while(true){
			System.out.println("\nSelect Option");
			System.out.println("1: Area Of Triangle ");
			System.out.println("2: Area Of Ractangle ");
			System.out.println("3: Area Of Square ");
			System.out.println("4: Area Of Circle ");
			System.out.println("5: Exit");
			System.out.print("Option Is: ");
			String optionInChar = scanner.next();
			int optionInInt = compute.charToIntConversion(optionInChar) ;
			
			
			double area, width, height, radius;
			switch(optionInInt){

			// For Triangle area 
			case 1: 
				System.out.print("Width Of Triangle: ");
				width = scanner.nextDouble();
				System.out.print("Height Of Triangle: ");
				height = scanner.nextDouble();
				area = compute.areaOfTriangle(width, height);
				System.out.println("Area Of Triangle Is: " + area);
				break;
				
				
			// For Rectangle area 
			case 2: 
				System.out.print("Width Of Rectangle: ");
				width = scanner.nextDouble();
				System.out.print("Height Of Rectangle: ");
				height = scanner.nextDouble();
				area = compute.areaOfRectangle(width, height);
				System.out.println("Area Of Rectangle Is: " + area);
				break;
				

			// For Square area 
			case 3: 
				System.out.print("Width Of Square: ");
				width = scanner.nextDouble();
				area = compute.areaOfSquare(width);
				System.out.println("Area Of Square Is: " + area);
				break;
				
				
			// For Circle Area
			case 4: 
				System.out.print("Radius Of Circle: ");
				radius = scanner.nextDouble();
				area = compute.areaOfCircle(radius);
				System.out.println("Area Of Circle Is: " + area);
				break;
				
			// To Exit from the program
			case 5:
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter Correct Option");
			}
			
		}
	}

}
