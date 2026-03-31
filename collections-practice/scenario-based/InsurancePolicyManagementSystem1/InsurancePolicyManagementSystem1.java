import java.util.*;
import java.time.LocalDate;

public class InsurancePolicyManagementSystem1 {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        List<Policy> allPolicies = Arrays.asList(
            new Policy("P101", "Raj", LocalDate.now().plusDays(10), "Health", 5000),
            new Policy("P102", "Rohit", LocalDate.now().plusDays(40), "Auto", 3000),
            new Policy("P103", "Raj", LocalDate.now().minusDays(2), "Home", 7000),
            new Policy("P104", "Nived", LocalDate.now().plusDays(20), "Health", 4500),
            new Policy("P101", "DuplicateRaj", LocalDate.now().plusDays(15), "Health", 5000) 
        );

        for (Policy p : allPolicies) manager.addPolicy(p);

        manager.displayAll(manager.hashSet, "HashSet");
        manager.displayAll(manager.linkedHashSet, "LinkedHashSet");
        manager.displayAll(manager.treeSet, "TreeSet");

        // Display expiring soon policies
        manager.displayExpiringSoon(manager.hashSet);

        // Display by coverage type
        manager.displayByCoverage(manager.hashSet, "Health");

        // Find duplicates
        manager.findDuplicates(allPolicies);

        // Performance comparison
        manager.performanceTest(allPolicies);
    }
}
