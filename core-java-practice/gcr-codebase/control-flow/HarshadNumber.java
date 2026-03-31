package controlFlow;

import java.util.Scanner;

public class HarshadNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int numCopy = num;
		int sum = 0;
		while(numCopy>0) {
			sum = sum + numCopy%10;
			numCopy = numCopy/10;
		}
		boolean isHarshad = num%sum==0;
		System.out.print(isHarshad?"Harshad":"Not Harshad");
		sc.close();
	}

}
