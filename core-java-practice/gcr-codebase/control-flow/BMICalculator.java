package controlFlow;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int heightInCm = sc.nextInt();
		int weight = sc.nextInt();
		double heightInM = heightInCm / 100.0;
		double bmi = weight / (heightInM * heightInM);
		System.out.printf("your BMI score is : %.2f \n", bmi);
		if (bmi <= 18.4) {
			System.out.print("UnderWeight");
		} else if (bmi >= 18.5 && bmi <= 24.9) {
			System.out.print("Normal");
		} else if (bmi > 24.9 && bmi <= 29.9) {
			System.out.print("Overweight");
		} else {
			System.out.print("Obese");
		}
		sc.close();
	}

}
