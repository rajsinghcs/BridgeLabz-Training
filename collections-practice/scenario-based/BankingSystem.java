import java.util.*;

public class BankingSystem {

    private Map<Integer, Double> accounts = new HashMap<>();

    
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void requestWithdrawal(int accountNumber) {
        withdrawalQueue.offer(accountNumber);
    }

    
    public void processWithdrawals(double amount) {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            int accNo = withdrawalQueue.poll();
            double balance = accounts.getOrDefault(accNo, 0.0);

            if (balance >= amount) {
                accounts.put(accNo, balance - amount);
                System.out.println("Account " + accNo + " withdrawn ₹" + amount);
            } else {
                System.out.println("Account " + accNo + " has insufficient balance");
            }
        }
    }


    public void displaySortedByBalance() {
        TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedAccounts
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            for (Integer accNo : entry.getValue()) {
                System.out.println("Account " + accNo + " : ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(101, 5000);
        bank.addAccount(102, 12000);
        bank.addAccount(103, 8000);

        bank.requestWithdrawal(101);
        bank.requestWithdrawal(103);
        bank.requestWithdrawal(102);

        bank.processWithdrawals(3000);

        bank.displaySortedByBalance();
    }
}
 