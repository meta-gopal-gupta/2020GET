package chemistry;

public class Main {

	public static void main(String[] args) {

		Expression expression = new Expression();

		String string = "CHOCw(CH3)33";
		if (expression.createIndividualElementList(string)) {
			System.out.println(expression.totalMass());
		}
		else {
			System.out.println("Wrong Expression");
		}
	}
}
