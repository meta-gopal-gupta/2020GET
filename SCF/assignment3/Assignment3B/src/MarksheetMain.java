import java.util.Scanner;
/*
 * Program to perform operation on grades
 * operation can be average of grades, max grade, min grade
 * and passed student (grade >= 40) percentage
 */

public class MarksheetMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		GradeOperation find = new GradeOperation();
		
		System.out.println("--------------------------------------------------------");
		System.out.println("|  Program to perform operations on grade. Grades      |");
		System.out.println("|  will be  between  0  and  100  both  inclusive.     |");
		System.out.println("|  It will Caculate Average Of Grades, Maximum Grade,  |");
		System.out.println("|  Minimum Grade and passed student ( Grade >= 40 )    |");
		System.out.println("|  percentage                                          |");
		System.out.println("--------------------------------------------------------");
		
		
		int numberOfStudent ;
		
		System.out.print("How many students in class ? : ");
		numberOfStudent = scanner.nextInt();

		int[] x = new int[numberOfStudent];
		
		for(int i=0;i<numberOfStudent;i++){
			System.out.print("Grade Of Student "+(i+1)+" :");
			x[i] = scanner.nextInt();
		}
		
		float averageOfAllGrades = find.averageOfAllGrades(x);
		int maximumGrade = find.maximumOfAllGrades(x);
		int minimumGrade = find.minimumOfAllGrades(x);
		float passedStudentsPercent = find.percentOfStudentPassed(x);
		System.out.printf("\nAverage Of All Grades: %.2f",averageOfAllGrades);
		System.out.println("\nMaximum Grade in All Grades: "+maximumGrade);
		System.out.println("Minimum Grade in All Grades: "+minimumGrade);
		System.out.printf("Passed Student Percentage: %.2f", passedStudentsPercent);
		
		scanner.close();
	}

}
