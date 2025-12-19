package controlFlow;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		int numCopy = num;
		int digits = 0;
		while(numCopy>0) {
			digits++;
			numCopy = numCopy/10;
		}
		numCopy = num;
		while(numCopy>0) {
			int r = numCopy%10;
			sum = sum + (int)Math.pow(r, digits);
			numCopy = numCopy/10;
		}
		System.out.print(sum==num?"ArmStrong":"Not ArmStrong");
		sc.close();
	}

}
