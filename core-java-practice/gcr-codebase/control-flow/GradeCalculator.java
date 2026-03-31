package controlFlow;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int physics = sc.nextInt();
		int chemistry = sc.nextInt();
		int maths = sc.nextInt();
		int totalMarks = physics + chemistry + maths;
		double percent = totalMarks / 3.0;
		if (percent > 80) {
			System.out.print("Your Grade is A and Remarks: Level 4,above agency-normalized standards");
		} else if (percent >= 70 && percent <= 79) {
			System.out.print("Your Grade is B and Remarks: Level 3,at agency-normalized standards");

		} else if (percent >= 60 && percent <= 69) {
			System.out.print("Your Grade is C and Remarks: Level 2,below, but approaching agency-normalized standards");

		} else if (percent >= 50 && percent <= 59) {
			System.out.print("Your Grade is D and Remarks: Level 1,well below agency-normalized standards");

		} else if (percent >= 40 && percent <= 49) {
			System.out.print("Your Grade is E and Remarks: Level 1-,too below agency-normalized standards");

		} else {
			System.out.print("Your Grade is R and Remarks:Remedial Standards");
		}
		sc.close();
	}

}
