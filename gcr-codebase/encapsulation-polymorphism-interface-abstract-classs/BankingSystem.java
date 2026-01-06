interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance; // protected for subclasses

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation (getters)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    // Abstract method
    abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 10;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SAV101", "Ravi", 50000);
        BankAccount acc2 = new CurrentAccount("CUR202", "Amit", 100000);

        BankAccount[] accounts = { acc1, acc2 };

        // Polymorphism
        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: " + acc.getBalance());

            double interest = acc.calculateInterest();
            System.out.println("Interest: " + interest);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.println("Loan Eligibility: " + loan.calculateLoanEligibility());
            }
        }
    }
}
