import java.util.*;
public class EmployeeWageComputationProblem {
	static final int isAbsent = 0;
    static final int isPartTime = 1;
    static final int isFullTime = 2;

    static final int wagePerHour = 20;
    static final int fullDayHours = 8;
    static final int partTimeHours = 8;
    static final int maxWorkingDays = 22;
    static final int maxWorkingHours = 130;
    
    public static void main(String args [] ){
    	System.out.println("Welcome to Employee Wage Computation Program");
    	
    	int totalWorkingDays = 0;
    	int totalWorkingHours=0;
    	int totalWage = 0;
    	
    	Random random = new Random();
    	
		//UC6: Calculate wages till a condition of total working hours
    	while(totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours ) {
    		totalWorkingDays++;

			//UC1: Check employee is present or absent
    		int employeeCheck = random.nextInt(3);
    		int workingHours = 0;
    		

			//UC4: Solving employee type using switch case
			//UC2: Calculate daily employee wage
			//UC3: Add part time employee & wage
    		switch(employeeCheck) {
    		case isFullTime : 
    			workingHours = fullDayHours;
    		    break;
    		
    		case isPartTime:
    			workingHours = partTimeHours;
    			break;
    		
    		default :
    			workingHours = 0;
    		}
    	
		// total working hours do not exceed monthly limit
    	if(workingHours + totalWorkingHours > maxWorkingHours ) {
    		workingHours = maxWorkingHours - totalWorkingHours ;
    	}
		int dailyWage = workingHours * wagePerHour;
            totalWorkingHours += workingHours;
            totalWage += dailyWage;
        //UC5: Calculating wages for a month
		System.out.println("Day " + totalWorkingDays +" | Hours Worked: " + workingHours +" | Daily Wage: Rs- " + dailyWage);
    		
    	}
		 // Final monthly summary
        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: Rs- " + totalWage);
    	
    	
    }

}
