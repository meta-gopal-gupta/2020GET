package postfix;

public class Main {
	
	public static void main(String[] args) {

		//String string = "3+4*5/5";
		//String string = "2*3  6+4*6/3+5";
		 String string = "(300 + (15 - 5) + 10 + (15 / 3) * 15)";
		// String string = "(4+89)*(6-5)/((3-2)*(2+2))";
		if(Expression.create(string)){
			Expression.display();
			Postfix.calculate();
			Postfix.displayPost();
			System.out.println("\nExpression Result : "+Postfix.answer());
		}
		else{
			System.out.println("Wrong Mathematical Expression");
		}

		System.out.print("Direct Result : ");
		System.out.println((300 + (15 - 5) + 10 + (15 / 3) * 15));
	}
}
