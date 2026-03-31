import java.util.Scanner;

public class EmployeeBonusCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int EMPLOYEE_COUNT = 10;

        // Arrays to store data
        double[] salary = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        // Variables to store totals
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Input salary and years of service
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Salary: ");
            double sal = scanner.nextDouble();

            System.out.print("Years of Service: ");
            double years = scanner.nextDouble();

            // Validate input
            if (sal <= 0 || years < 0) {
                System.out.println("Invalid input! Please enter valid values.");
                i--; // repeat the same employee
                continue;
            }

            salary[i] = sal;
            yearsOfService[i] = years;
        }

        // Calculate bonus and new salary
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus
            }

            newSalary[i] = salary[i] + bonus[i];

            // Calculate totals
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display results
        System.out.println("\nEmployee Bonus Details:");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Employee " + (i + 1) + " | Old Salary: " + salary[i] + " | Bonus: " + bonus[i]
                    + " | New Salary: " + newSalary[i]);
        }

        // Display totals
        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}
