package scenario_based;

import java.util.*;

public class LineComputationProgram {
	
	
	// uc-1 using the Cartesian system, calculate length of line1
	public static double calculateLengthOfLine1(double x1, double x2, double y1, double y2) {
		double length_Of_a_Line1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		System.out.printf("Length of a line1: %.2f\n",length_Of_a_Line1);
		return length_Of_a_Line1;
	}
    
	//using the Cartesian system, calculate length of line2
	public static double calculateLengthOfLine2(double x3, double x4, double y3, double y4) {
		double length_Of_a_Line2 = Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
		System.out.printf("Length of Line2: %.2f\n",length_Of_a_Line2);
		return length_Of_a_Line2;
	}
    
	
	// uc-2  Using Java equals method to check equality of 2 Lengths
	public static boolean isEqual(Double length_Of_a_Line1, Double length_Of_a_Line2) {
		System.out.println("Equality of two line using equals method: ");
		return length_Of_a_Line1.equals(length_Of_a_Line2);
	}
    
	
	//uc-3 Using Java compareTo method to compare 2 Length
	public static void compareTo(Double length_Of_a_Line1, Double length_Of_a_Line2) {
		int result = length_Of_a_Line1.compareTo(length_Of_a_Line2);
		if (result == 0) {
			System.out.println("Both lines are of equal length");
		} else if (result > 0) {
			System.out.println("Line 1 is longer than Line 2");
		} else {
			System.out.println("Line 1 is shorter than Line 2");
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Line Comparison Computation Program on Master Branch");
		
		//input co-ordinates of line1
		System.out.println("Enter the Line-1 co-ordinates");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();

		////input co-ordinates of line2
		System.out.println("Enter the Line-2 co-ordinates");
		double x3 = sc.nextDouble();
		double y3 = sc.nextDouble();
		double x4 = sc.nextDouble();
		double y4 = sc.nextDouble();
		double length_Of_a_Line1 = calculateLengthOfLine1(x1, x2, y1, y2);
		double length_Of_a_Line2= calculateLengthOfLine2(x3, x4, y3, y4);
	    compareTo(length_Of_a_Line1, length_Of_a_Line2);
	}
}
