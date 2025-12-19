package controlFlow;

import java.util.Scanner;

public class CountDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int digits = 0;
		if (num == 0) {
			digits++;
		}
		while (num > 0) {
			digits++;
			num = num / 10;
		}
		System.out.print("Digits in given integer is : " + digits);
		sc.close();
	}

}
