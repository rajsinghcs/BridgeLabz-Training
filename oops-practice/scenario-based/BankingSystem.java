import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {

    void openAccount();

    void updateAccountDetails();

    void checkBalance(int accountNo);

    void withdrawOrDepositAmount();
}

class Bank implements BankService {

    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Account> accounts = new HashMap<>();

    @Override
    public void openAccount() {
        System.out.println("\nOpen New Account");

        System.out.print("Account Type (Savings/Current): ");
        String accountType = sc.next();

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Gender (M/F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.print("Initial Deposit: ");
        int balance = sc.nextInt();

        int accountNo = (int) (Math.random() * 100000);

        Account acc;
        if (accountType.equalsIgnoreCase("Savings")) {
            acc = new SavingsAccount(accountNo, name, age, gender, balance, accountType);
        } else {
            acc = new CurrentAccount(accountNo, name, age, gender, balance, accountType);
        }

        accounts.put(accountNo, acc);
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + accountNo);
    }

    @Override
    public void updateAccountDetails() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter new name: ");
        acc.name = sc.next();

        System.out.print("Enter new age: ");
        acc.age = sc.nextInt();

        System.out.println("Account details updated successfully!");
    }

    @Override
    public void checkBalance(int accountNo) {
        Account acc = accounts.get(accountNo);
        if (acc == null) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Available Balance: ₹" + acc.balance);
        }
    }

    @Override
    public void withdrawOrDepositAmount() {
        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            Account acc = accounts.get(accNo);
            if (acc == null) {
                System.out.println("Account not found!");
                return;
            }

            System.out.print("1. Deposit\n2. Withdraw\nChoose option: ");
            int choice = sc.nextInt();

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            if (choice == 1) {
                acc.balance += amount;
                System.out.println("Amount deposited successfully!");
            } else if (choice == 2) {
                if (amount > acc.balance) {
                    throw new InsufficientBalanceException("Insufficient balance!");
                }
                acc.balance -= amount;
                System.out.println("Amount withdrawn successfully!");
            } else {
                System.out.println("Invalid choice!");
            }

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Account {
    int accountNo;
    String name;
    int age;
    char gender;
    int balance;
    String accountType;

    public Account(int accountNo, String name, int age, char gender, int balance, String accountType) {
        this.accountNo = accountNo;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.balance = balance;
        this.accountType = accountType;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(int accountNo, String name, int age, char gender, int balance, String accountType) {
        super(accountNo, name, age, gender, balance, accountType);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(int accountNo, String name, int age, char gender, int balance, String accountType) {
        super(accountNo, name, age, gender, balance, accountType);
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Open Account");
            System.out.println("2. Update Account Details");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit / Withdraw");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bank.openAccount();
                    break;
                case 2:
                    bank.updateAccountDetails();
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    bank.checkBalance(sc.nextInt());
                    break;
                case 4:
                    bank.withdrawOrDepositAmount();
                    break;
                case 5:
                    System.out.println("Thank you for using Banking System!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}