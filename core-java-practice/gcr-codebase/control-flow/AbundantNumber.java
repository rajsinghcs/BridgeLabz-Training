package controlFlow;

import java.util.Scanner;

public class AbundantNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		boolean isAbundant = sum > num;
		System.out.print(isAbundant ? "Abundant" : "Not Abundant");
		sc.close();
	}

}
