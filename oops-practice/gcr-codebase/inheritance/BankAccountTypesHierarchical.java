class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accNum, double bal) {
        this.accountNumber = accNum;
        this.balance = bal;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accNum, double bal, double rate) {
        super(accNum, bal);
        this.interestRate = rate;
    }

    void displayAccountType() {
        System.out.println("Savings Account with interest: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accNum, double bal, double limit) {
        super(accNum, bal);
        this.withdrawalLimit = limit;
    }

    void displayAccountType() {
        System.out.println("Checking Account with limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int termMonths;

    FixedDepositAccount(String accNum, double bal, int term) {
        super(accNum, bal);
        this.termMonths = term;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit for " + termMonths + " months");
    }
}

public class BankAccountTypesHierarchical {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount("12345", 1000, 5);
        s.displayAccountType();
        CheckingAccount c = new CheckingAccount("12345", 1000, 1000);
        c.displayAccountType();
        FixedDepositAccount f = new FixedDepositAccount("12345", 1000, 12);
        f.displayAccountType();
    }
}
