package controlFlow;

import java.util.Scanner;

public class CaculatorUsingSwitch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double input1 = sc.nextDouble();
		double input2 = sc.nextDouble();
		String op = sc.next();
		switch (op) {
		case "+":
			System.out.print("sum is : " + (input1 + input2));
			break;
		case "-":
			System.out.print("subtraction is : " + (input1 - input2));
			break;
		case "*":
			System.out.print("multiplication is : " + (input1 * input2));
			break;
		case "/":
			System.out.print("Divison is : " + (input1 / input2));
			break;
		default :
			System.out.print("Enter valid input");
		}
		sc.close();
	}

}
