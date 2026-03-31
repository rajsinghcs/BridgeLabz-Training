import java.util.ArrayList;
import java.util.List;

class Wallet {
    private User user;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Wallet(User user) {
        this.user = user;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("ADD", amount));
    }

    public void withdrawMoney(double amount)
            throws InsufficientBalanceException {

        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public void recordTransaction(Transaction t) {
        transactions.add(t);
    }

    public void showTransactions() {
        transactions.forEach(System.out::println);
    }
}
