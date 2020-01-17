
public class GradeOperation {
	/*
	 * To find average of all the grades
	 * @param array of all grades
	 * @return average of all grades
	 */
	float averageOfAllGrades(int[] grades){
		int totalOfGrades = 0;
		for(int index=0;index<grades.length;index++){
			totalOfGrades += grades[index];
		}
		float average = (float)totalOfGrades/ grades.length;
		return average;
	}
	
	/*
	 * To find maximum grade in all grades
	 * @param array of all grades
	 * @return maximum grade
	 */
	int maximumOfAllGrades(int[] grades){
		int maxGrade = grades[0];
		for(int index=0;index<grades.length;index++){
			if(maxGrade < grades[index]){
				maxGrade = grades[index];
			}
		}
		return maxGrade;
	}
	
	/*
	 * To find minimum grade in all grades
	 * @param array of all grades
	 * @return minimum grade
	 */
	int minimumOfAllGrades(int[] grades){
		int minGrade = grades[0];
		for(int index=0;index<grades.length;index++){
			if(minGrade > grades[index]){
				minGrade = grades[index];
			}
		}
		return minGrade;
	}
	
	/*
	 * To find percent of student have grade >=40
	 * @param array of all grades
	 * @return percent of passed studente
	 */
	float percentOfStudentPassed(int[] grades){
		float passedStudentPercent = 0;
		float minimumPassingMarks = 40;
		int passedStudents = 0;
		for(int index=0;index<grades.length;index++){
			if(grades[index] > minimumPassingMarks){
				passedStudents++;
			}
		}
		passedStudentPercent = ((float)(passedStudents)/grades.length)*100;
		return passedStudentPercent;
	}
}
