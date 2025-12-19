package controlFlow;

import java.util.*;

public class PrimeOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean isPrime = true;
		;
		if (num < 2) {
			isPrime = false;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.print(isPrime ? "Prime" : "Not Prime");
		sc.close();
	}

}
