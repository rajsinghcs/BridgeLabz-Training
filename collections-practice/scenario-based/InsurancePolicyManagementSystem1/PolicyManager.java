import java.time.LocalDate;
import java.util.*;

class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    void displayAll(Set<Policy> set, String setName) {
        System.out.println("Displaying all policies in " + setName + ":");
        for (Policy p : set) {
            System.out.println(p);
        }
        System.out.println();
    }

    void displayExpiringSoon(Set<Policy> set) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("Policies expiring in next 30 days:");
        for (Policy p : set) {
            if (!p.expiryDate.isBefore(today) && !p.expiryDate.isAfter(limit)) {
                System.out.println(p);
            }
        }
        System.out.println();
    }

    void displayByCoverage(Set<Policy> set, String coverageType) {
        System.out.println("Policies with coverage type: " + coverageType);
        for (Policy p : set) {
            if (p.coverageType.equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }
        System.out.println();
    }

    void findDuplicates(List<Policy> allPolicies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : allPolicies) {
            if (!seen.add(p.policyNumber)) {
                duplicates.add(p.policyNumber);
            }
        }

        System.out.println("Duplicate policy numbers: " + duplicates);
        System.out.println();
    }

    void performanceTest(List<Policy> policies) {
        System.out.println("Performance Test (Adding, Searching, Removing):\n");

        // HashSet
        Set<Policy> hs = new HashSet<>();
        long start = System.nanoTime();
        for (Policy p : policies) hs.add(p);
        long end = System.nanoTime();
        System.out.println("HashSet add: " + (end - start) + " ns");

        start = System.nanoTime();
        hs.contains(policies.get(policies.size() / 2));
        end = System.nanoTime();
        System.out.println("HashSet search: " + (end - start) + " ns");

        start = System.nanoTime();
        hs.remove(policies.get(0));
        end = System.nanoTime();
        System.out.println("HashSet remove: " + (end - start) + " ns\n");

        // LinkedHashSet
        Set<Policy> lhs = new LinkedHashSet<>();
        start = System.nanoTime();
        for (Policy p : policies) lhs.add(p);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add: " + (end - start) + " ns");

        start = System.nanoTime();
        lhs.contains(policies.get(policies.size() / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet search: " + (end - start) + " ns");

        start = System.nanoTime();
        lhs.remove(policies.get(0));
        end = System.nanoTime();
        System.out.println("LinkedHashSet remove: " + (end - start) + " ns\n");

        // TreeSet
        Set<Policy> ts = new TreeSet<>();
        start = System.nanoTime();
        for (Policy p : policies) ts.add(p);
        end = System.nanoTime();
        System.out.println("TreeSet add: " + (end - start) + " ns");

        start = System.nanoTime();
        ts.contains(policies.get(policies.size() / 2));
        end = System.nanoTime();
        System.out.println("TreeSet search: " + (end - start) + " ns");

        start = System.nanoTime();
        ts.remove(policies.get(0));
        end = System.nanoTime();
        System.out.println("TreeSet remove: " + (end - start) + " ns\n");
    }
}