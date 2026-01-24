import java.util.*;
import java.time.LocalDate;

public class InsurancePolicyManagementSystem2 {

    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Add Policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        treeMap
            .computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>())
            .add(policy);
    }

    // Retrieve by policy number 
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // Policies expiring in next 30 days
    public void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("\nPolicies expiring within 30 days:");
        for (Map.Entry<LocalDate, List<Policy>> entry :
                treeMap.subMap(today, true, limit, true).entrySet()) {
            entry.getValue().forEach(System.out::println);
        }
    }

    // Policies by policyholder name
    public void policiesByHolder(String name) {
        System.out.println("\nPolicies for " + name + ":");
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Policy policy = iterator.next().getValue();
            if (policy.getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(policy.getPolicyNumber());
            }
        }

        treeMap.headMap(today).clear();
        System.out.println("\nExpired policies removed.");
    }

    // Display all policies 
    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        hashMap.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem2 system = new InsurancePolicyManagementSystem2();

        system.addPolicy(new Policy("P101", "Ravi", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P102", "Amit", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P103", "Ravi", LocalDate.now().minusDays(5), "Home", 7000));
        system.addPolicy(new Policy("P104", "Neha", LocalDate.now().plusDays(20), "Health", 4500));

        system.displayAllPolicies();

        System.out.println("\nRetrieve Policy P102:");
        System.out.println(system.getPolicyByNumber("P102"));

        system.policiesExpiringSoon();
        system.policiesByHolder("Ravi");
        system.removeExpiredPolicies();
        system.displayAllPolicies();
    }
}
